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

@Controller
public class HelloController {

    @Autowired
    private DriverManagerDataSource dataSauce;

    String owner = "TheStudentProgrammer";
    String confirm = "";
    long hack = 0;                                                                  // this will be made clear

    @RequestMapping(value = "/", method = RequestMethod.GET)
    /** Working as intended */
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

    /***************************************** members *********************************************************/
    @RequestMapping(value = "/editor", method = RequestMethod.POST)
    /** this looping construct can't be right. a single user obj would be better than a List obj */
    public String editMember(ModelMap model, @RequestParam("editId") long id) {
        JdbcTemplate jdbctemplate = new JdbcTemplate(dataSauce);
        return "members/editor";
    }


    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)
    /** Currently adding fields */
    public String calculate(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("age") int age, @RequestParam("invoice_num") String invoice_num, @RequestParam("client") String client, @RequestParam("driver") String driver, @RequestParam("origin") String origin, @RequestParam("destination") String destination, @RequestParam("retour") Boolean retour, @RequestParam("wknd") Boolean wknd, @RequestParam("human") Boolean human, @RequestParam("prise") Boolean prise, @RequestParam("interne") Boolean interne, @RequestParam("urgence") Boolean urgence, @RequestParam("abusive") Boolean abusive) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("INSERT INTO invoice(username,password,age,invoice_num,client,driver,origin,destination,retour,wknd,human,prise,interne,urgence,abusive) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", username, password, age, invoice_num, client, driver, origin, destination, retour, wknd, human, prise, interne, urgence, abusive);
        model.addAttribute("username", username);
        model.addAttribute("procedure", confirm);
        return "members/confirmation";
    }


    @RequestMapping(value = "/invoiceList", method = RequestMethod.POST)
    /** Working as intended */
    public String listMembers(ModelMap model) {
        /** Java solution */
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Invoice> allInvoices = jdbcTemplate.query("SELECT * FROM invoice", new InvoiceMapper());
        String theLot = "";
        for (Invoice member : allInvoices) {
            if (member.getAge() >= 18) {
                /** html output of adults only */
                theLot += member.getId() + "&emsp;" +
                        member.getInvoiceName() + "&emsp;" +
                        member.getPassword() + "&emsp;" +
                        member.getAge() + "&emsp;" +
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
            }
            /** console output of all members */
            System.out.println(member.getId() + "\t" +
                    member.getInvoiceName() + "\t" +
                    member.getPassword() + "\t" +
                    member.getAge() + "\t" +
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
        List<Invoice> adults = jdbcT.query("SELECT * FROM USERS WHERE age >= 18", new InvoiceMapper());
        int troops = 0;
        String justAdults = "";
        for (Invoice adult : adults) {
            troops += 1;
            /** html output of adults */
            justAdults += adult.getId() + "&emsp;" +
                    adult.getInvoiceName() + "&emsp;" +
                    adult.getPassword() + "&emsp;" +
                    adult.getAge() + "&emsp;" +
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
                    adult.getInvoiceName() + "\t" +
                    adult.getPassword() + "\t" +
                    adult.getAge() + "\t" +
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
        return "members/memberList";
    }


    @RequestMapping(value = "/changed", method = RequestMethod.POST)
    /** Working... */
    public String editMember(ModelMap model, @RequestParam("newName") String username, @RequestParam("newPass") String password, @RequestParam("newAge") String age) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("UPDATE USERS SET username =?, password =?, age =? WHERE id =?", username, password, age, hack);
        model.addAttribute("procedure", confirm);
        return "members/changed";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    /** Working... */
    public String deleteMember(ModelMap model) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("DELETE FROM USERS WHERE ID =?", hack);
        model.addAttribute("procedure", "Delete Member Record");
        return "members/changed";
    }
}
