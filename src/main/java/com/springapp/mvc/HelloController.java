package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String calculate(ModelMap model, @RequestParam("invoice_num") String invoice_num, @RequestParam("client") String client, @RequestParam("driver") String driver, @RequestParam("origin") String origin, @RequestParam("destination") String destination, @RequestParam(value="retour", required=false) Boolean retour, @RequestParam( required=false, value="wknd") Boolean wknd, @RequestParam(required=false, value="human") Boolean human, @RequestParam(required=false, value="prise") Boolean prise, @RequestParam(required=false, value="interne") Boolean interne, @RequestParam(required=false, value="urgence") Boolean urgence, @RequestParam(required=false, value="abusive") Boolean abusive) {
        if(wknd == null) { wknd = false; }
        if(retour == null) { retour = false; }
        if(human == null) { human = false; }
        if(interne == null) { interne = false; }
        if(urgence == null) { urgence = false; }
        if(abusive == null) { abusive = false; }


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("INSERT INTO invoice(invoice_num,client,driver,origin,destination,retour,wknd,human,prise,interne,urgence,abusive) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", invoice_num, client, driver, origin, destination, retour, wknd, human, prise, interne, urgence, abusive);
      //  model.addAttribute("username", username);
        model.addAttribute("procedure", confirm);
       // System.out.println(dateStamp);
        return "confirmation";
    }


    @RequestMapping(value = "/invoiceList", method = RequestMethod.POST)
    public String listMembers(ModelMap model) {
        /** Java solution */
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Invoice> allInvoices = jdbcTemplate.query("SELECT * FROM invoice", new InvoiceMapper());
        String theLot = "";
        for (Invoice member : allInvoices) {
            /** html output of all invoices **/
            theLot += member.getId() + "&emsp;" +
               //     member.getDateStamp() + "&emsp;" +
                    member.getInvoiceNum() + "&emsp;" +
                    member.getClient() + "&emsp;" +
                    member.getOrigin() + "&emsp;" +
                    member.getDestination() + "&emsp;" +
                    member.getRetour() + "&emsp;" +
                    member.getWknd() + "&emsp;" +
                    member.getHuman() + "&emsp;" +
                    member.getPrise() + "&emsp;" +
                    member.getInterne() + "&emsp;" +
                    member.getUrgence() + "&emsp;" +
                    member.getAbusive() + "<br>";

            /** console output of all invoices */
            System.out.println(member.getId() + "\t" +
              //     member.getDateStamp() + "\t" +
                    member.getInvoiceNum() + "\t" +
                    member.getClient() + "\t" +
                    member.getOrigin() + "\t" +
                    member.getDestination() + "\t" +
                    member.getRetour() + "\t" +
                    member.getWknd() + "\t" +
                    member.getHuman() + "\t" +
                    member.getPrise() + "\t" +
                    member.getInterne() + "\t" +
                    member.getUrgence() + "\t" +
                    member.getAbusive());
        }

        /** Query solution */
        JdbcTemplate jdbcT = new JdbcTemplate(dataSauce);
        List<Invoice> adults = jdbcT.query("SELECT * FROM invoice", new InvoiceMapper());
        int troops = 0;
        String justAdults = "";
        for (Invoice adult : adults) {
            troops += 1;
            /** html output of adults */
            justAdults += adult.getId() + "&emsp;" +
                    adult.getOrigin() + "&emsp;" +
                    adult.getClient() + "&emsp;" +
                    adult.getDriver() + "&emsp;" +
                    adult.getDestination() + "&emsp;" +
                    adult.getRetour() + "&emsp;" +
                    adult.getInterne() + "&emsp;" +
                    adult.getUrgence() + "&emsp;" +
                    adult.getAbusive() + "&emsp;" +
                    "<br>";

            /** console output of adults */
            System.out.println(adult.getId() + "\t" +
                    adult.getOrigin() + "\t" +
                    adult.getDestination() + "\t" +
                    adult.getClient() + "\t" +
                    adult.getDriver() + "\t" +
                    adult.getRetour() + "\t" +
                    adult.getInterne() + "\t" +
                    adult.getUrgence() + "\t" +
                    adult.getAbusive());
        }


        System.out.println(allInvoices.iterator());                // failed:seems to find address of table instead of contents of table elements
        model.addAttribute("userCount", allInvoices.size());       // works: posts the total number of table entries
        model.addAttribute("owner", owner);                     // works: posts a string to the page
        model.addAttribute("roleCall", theLot);                 // works: Java solution to age data restriction
        model.addAttribute("theDraft", justAdults);             // works: Query solution to age data restriction
        model.addAttribute("eligible", troops);                 // works: counts total adults
        return "invoiceList";
    }

}
