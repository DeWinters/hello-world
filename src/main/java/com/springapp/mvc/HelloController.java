package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Locale;
import java.sql.Timestamp;

@Controller
public class HelloController {

    @Autowired
    private DriverManagerDataSource dataSauce;

    String owner = "TheStudentProgrammer";
    String confirm = "";
    long hack = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)    /** counts page visits (possible brute-force prevention?) **/
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        HttpSession session = request.getSession(true);
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter != null) {
            session.setAttribute("counter", counter + 1);
        } else {
            session.setAttribute("counter", 1);
        }

        System.out.println("COUNTER VALUE:" + session.getAttribute("counter"));
        model.addAttribute("greeting", "Enter New Member details");
        confirm = "New Member Entry";
        return "index";
    }

    /***************************************** Invoice *********************************************************/

    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)
    public String calculate(ModelMap model, @RequestParam("invoice_num") String invoice_num, @RequestParam("client") String client,
                            @RequestParam("driver") String driver, @RequestParam("origin") String origin, @RequestParam("destination") String destination,
                            @RequestParam(value="retour", required=false) Boolean retour, @RequestParam( required=false, value="wknd") Boolean wknd,
                            @RequestParam(required=false, value="human") Boolean human, @RequestParam(required=false, value="prise") Boolean prise,
                            @RequestParam(required=false, value="interne") Boolean interne, @RequestParam(required=false, value="urgence") Boolean urgence,
                            @RequestParam(required=false, value="abusive") Boolean abusive, @RequestParam(value="date_stamp") String dateStamp,
                            @RequestParam(value="collection") String collection, @RequestParam(value="delivery") String delivery) {

        if(wknd == null) { wknd = false; }      // checkbox=false normalizations
        if(retour == null) { retour = false; }
        if(human == null) { human = false; }
        if(prise == null) { prise = false; }
        if(interne == null) { interne = false; }
        if(urgence == null) { urgence = false; }
        if(abusive == null) { abusive = false; }

        System.out.println(dateStamp);                                                          // just date
        System.out.println(collection);                                                         // just time

        String collectionStamp = dateStamp + " " + collection;       /** collection_time creation **/
        System.out.println(collectionStamp);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);
        Date collectionTime = null;
        try {
            collectionTime = format.parse(collectionStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(collectionTime);                                                     // collectionTime

        String deliveryStamp = dateStamp + " " + delivery;          /** delivery_time creation **/
        System.out.println(deliveryStamp);
        Date deliveryTime = null;
        try {
            deliveryTime = format.parse(deliveryStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(deliveryTime);                                                       // deliveryTime

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("INSERT INTO invoice(invoice_num,client,driver,origin,destination,retour,wknd,human,prise," +
                "interne,urgence,abusive,collection_time,delivery_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", invoice_num, client, driver,
                origin, destination, retour, wknd, human, prise, interne, urgence, abusive, collectionTime, deliveryTime);
        model.addAttribute("procedure", confirm);
        return "confirmation";
    }


    @RequestMapping(value = "/invoiceList", method = RequestMethod.POST)
    public String listMembersPost(ModelMap model) {
        return listOutput(model);
    }

    @RequestMapping(value = "/invoiceList", method = RequestMethod.GET)
    public String listMembersGet(ModelMap model) {
      return listOutput(model);
    }


    private String listOutput(ModelMap invoiceMap){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Invoice> allInvoices = jdbcTemplate.query("SELECT * FROM invoice", new InvoiceMapper());

        String theLot = "";                                 /** jsp output of all invoices **/
        for (Invoice invoice : allInvoices) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
            String collectionString;
            if (invoice.getCollectionTime() == null) {
                collectionString = "UnDated";
            } else {
                collectionString = format.format(invoice.getCollectionTime());}

            theLot += "ID: " +invoice.getId() +
                    "&emsp; INVOICE:" + invoice.getInvoiceNum() +
                    "&emsp; CLIENT:" +  invoice.getClient() +
                    "<br>" +
                    "&emsp; ORIGIN:" +  invoice.getOrigin() +
                    "&emsp; COLLECTION:" + collectionString +
                    "<br>" +
                    "&emsp; DESTINATION:" + invoice.getDestination() +
                    "&emsp; DELIVERY:" + invoice.getDeliveryTime() +
                    "<br>" +
                    "&emsp; RET:" + invoice.getRetour() +
                    "&emsp; WKND" + invoice.getWknd() +
                    "&emsp; HUMAN" + invoice.getHuman() +
                    "&emsp; PRISE" + invoice.getPrise() +
                    "&emsp; INTERN" + invoice.getInterne() +
                    "&emsp; URGEN" + invoice.getUrgence() +
                    "&emsp; ABUSE" + invoice.getAbusive() +
                    "<br><br>";

            /** console output of all invoices */
            System.out.println(invoice.getId() + "\t" + invoice.getInvoiceNum() + "\t" + invoice.getClient() + "\t" +
                    invoice.getOrigin() + "\t" +  collectionString + "\t" + invoice.getDestination() + "\t" +
                    invoice.getDeliveryTime() + "\t" + invoice.getRetour() + "\t" + invoice.getWknd() + "\t" +
                    invoice.getHuman() + "\t" + invoice.getPrise() + "\t" + invoice.getInterne() + "\t" +
                    invoice.getUrgence() + "\t" + invoice.getAbusive());
        }

        System.out.println(allInvoices.iterator());                // failed:seems to find address of table instead of contents of table elements
        invoiceMap.addAttribute("userCount", allInvoices.size());       // works: posts the total number of table entries
        invoiceMap.addAttribute("owner", owner);                     // works: posts a string to the page
        invoiceMap.addAttribute("roleCall", theLot);                 // works: Java solution to age data restriction
        return "invoiceList";
    }

}
