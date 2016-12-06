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
import java.math.BigDecimal;
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

        /** counts page visits (possible brute-force prevention?) **/
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
                            @RequestParam("driver") String driver, @RequestParam("origin") int origin, @RequestParam("destination") int destination,
                            @RequestParam(value="retour", required=false) Boolean retour, @RequestParam( required=false, value="wknd") Boolean wknd,
                            @RequestParam(required=false, value="human") Boolean human, @RequestParam(required=false, value="prise") Boolean prise,
                            @RequestParam(required=false, value="interne") Boolean interne, @RequestParam(required=false, value="urgence") Boolean urgence,
                            @RequestParam(required=false, value="abusive") Boolean abusive, @RequestParam(value="date_stamp") String dateStamp,
                            @RequestParam(value="collection") String collection, @RequestParam(value="delivery") String delivery) {

        if(wknd == null) { wknd = false; }                           /** checkbox=false normalizations **/
        if(retour == null) { retour = false; }
        if(human == null) { human = false; }
        if(prise == null) { prise = false; }
        if(interne == null) { interne = false; }
        if(urgence == null) { urgence = false; }
        if(abusive == null) { abusive = false; }

        String collectionStamp = dateStamp + " " + collection;       /** collection_time creation **/
        System.out.println(collectionStamp);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);
        Date collectionTime = null;
        try {
            collectionTime = format.parse(collectionStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(collectionTime);

        String deliveryStamp = dateStamp + " " + delivery;          /** delivery_time creation **/
        System.out.println(deliveryStamp);
        Date deliveryTime = null;
        try {
            deliveryTime = format.parse(deliveryStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(deliveryTime);

        String duration = null;                                     /** Voyage duration calculation **/
        if(collectionTime != null && deliveryTime != null) {
            DurationCreator voyage = new DurationCreator(collectionTime, deliveryTime);
            duration = voyage.ToString();
        }

        JdbcTemplate jdbcTarif = new JdbcTemplate(dataSauce);       /** Tariff selection **/
        List<Route> allRoutes = jdbcTarif.query("SELECT * FROM ROUTE WHERE (id_origin=?) AND(id_destined=?)", new RouteMapper(), origin, destination);
        BigDecimal tarifRate =null;
        if(allRoutes.size() == 1){
            /** set tarif rate (based on dayRate for now) **/
            for(Route theRoute : allRoutes){
                tarifRate = theRoute.getDayTarif();
            }
        }
        else if(allRoutes.size() > 1 ){ /** do some error handling **/ }
        else if (allRoutes.size() <0){  /** Report No-Tarif-Set  **/ }





        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);    /** Send compiled invoice data to the database **/
        jdbcTemplate.update("INSERT INTO invoice(invoice_num,client,driver,origin,destination,retour,wknd,human," +
                                                "prise,interne,urgence,abusive,collection_time,delivery_time,duration,tarif_rate)" +
                                                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", invoice_num, client, driver,
                                                origin, destination, retour, wknd, human, prise, interne, urgence,
                                                abusive, collectionTime, deliveryTime, duration, tarifRate);
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


    private String listOutput(ModelMap invoiceMap){                             /** Collect and list all invoices **/
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Invoice> allInvoices = jdbcTemplate.query("SELECT * FROM invoice", new InvoiceMapper());

        String theLot = null;                                 // jsp invoice string list
        String tabledInvoices = null;                         // jsp invoice list table builder;
        for (Invoice invoice : allInvoices) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

            String collectionString;
            if (invoice.getCollectionTime() == null) { collectionString = "--:--"; }
            else { collectionString = format.format(invoice.getCollectionTime()); }

            String deliveryString;
            if (invoice.getDeliveryTime() == null) { deliveryString = "--:--"; }
            else { deliveryString = format.format(invoice.getDeliveryTime()); }

            /** console output of all invoices **/
            System.out.println(invoice.getId() + "\t" + invoice.getInvoiceNum() + "\t" + invoice.getClient() + "\t" +
                    invoice.getOrigin() + "\t" +  collectionString + "\t" + invoice.getDestination() + "\t" +
                    deliveryString + "\t" + invoice.getRetour() + "\t" + invoice.getWknd() + "\t" +
                    invoice.getHuman() + "\t" + invoice.getPrise() + "\t" + invoice.getInterne() + "\t" +
                    invoice.getUrgence() + "\t" + invoice.getAbusive());

            /** Tabled jsp output of all invoices **/
            tabledInvoices +="<tr><td>" + invoice.getId() +"</td><td>"+ invoice.getInvoiceNum() +"</td><td>"+ invoice.getClient() +"</td><td>"+
                    invoice.getDriver() +"</td><td>"+ collectionString + "</td><td>" +  invoice.getOrigin() + "</td><td>"+
                    deliveryString +"</td><td>"+ invoice.getDestination() +"</td><td>"+ invoice.getRetour()+ "</td><td>"+
                    invoice.getWknd() +"</td><td>"+ invoice.getHuman() +"</td><td>"+ invoice.getPrise()+ "</td><td>"+
                    invoice.getInterne() +"</td><td>"+ invoice.getUrgence() +"</td><td>"+ invoice.getAbusive() +"</td><td>"+
                    invoice.getDayTarif() +"</td><td>"+ invoice.getDuration() +"</td></tr>";
        }

        invoiceMap.addAttribute("userCount", allInvoices.size());  // works: posts the total number of table entries
        invoiceMap.addAttribute("owner", owner);                   // works: posts a string to the page
        invoiceMap.addAttribute("roleCall", theLot);               // works: Java solution
        invoiceMap.addAttribute("boxedData", tabledInvoices);      /** invoice list jsp output **/
        return "invoiceList";
    }

}
