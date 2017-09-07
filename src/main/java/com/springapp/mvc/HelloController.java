package com.springapp.mvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.thetransactioncompany.cors.CORSConfiguration;
import com.thetransactioncompany.cors.CORSFilter;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Locale;
import java.sql.Timestamp;

//nope import org.springframework.web.bind.annotation.CrossOrigin;



@Controller
public class HelloController {

    @Autowired
    private DriverManagerDataSource dataSauce;


    private JsonArray jboy;
    private GreetingController gtroller;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        model.addAttribute("guestlist", getLogAsString() );
        model.addAttribute("jsonlist", getLogAsJSON());
        return "index";
    }


    @RequestMapping(value = "/insertGuest", method = RequestMethod.GET)
    public String insertNewGuest(ModelMap model,
                                   @RequestParam("firstname") String firstName,
                                   @RequestParam("lastname") String lastName){

        insertNew(firstName, lastName);
        model.addAttribute("guestlist", getLogAsString());
        return "index";
    }




    @RequestMapping(value = "/gimmeJson", method = RequestMethod.GET)
    @ResponseBody
    public String getLogAsJSON(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Client> guestLog = jdbcTemplate.query("SELECT * FROM guests", new ClientMapper());
        Gson gson;
        //String Jthing = gson.toJson(guestLog);
        String Json ="[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"firstName\": \"Bruce\",\n" +
                "    \"lastName\": \"Willis\",\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"firstName\": \"Bruce\",\n" +
                "    \"lastName\": \"Willis\",\n" +
                "  }\n" +
                "]";

        String Json2 ="[{'id': '1','firstName': 'Bruce','lastName': 'Willis',},{'id': '2','firstName': 'Bruce','lastName': 'Willis',]";
        return Json2;
    }

    public String getLogAsString() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Client> guestLog = jdbcTemplate.query("SELECT * FROM guests", new ClientMapper());

        String allGuests= "";
        for(Client guest : guestLog){
            allGuests += "<option class=\"ticket\" value=\"" + guest.getId() + "\">" +
                    guest.getId() +
                    guest.getFirstName() +
                    guest.getLastName() + "<br/>" +
                    "</option>";
        }
        return allGuests;
    }



    public void insertNew(String firstName, String lastName){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("INSERT INTO guests(first_name,last_name)" +
                                "VALUES(?,?)", firstName, lastName);
    }
}
