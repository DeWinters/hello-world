package com.springapp.mvc;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
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
import java.text.SimpleDateFormat;
import java.text.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//nope import org.springframework.web.bind.annotation.CrossOrigin;



@Controller
public class HelloController {

    @Autowired
    private DriverManagerDataSource dataSauce;

    @Autowired
    private DAO dao;

    Gson gson = new Gson();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        model.addAttribute("guestlist", dao.getLogAsString());
        model.addAttribute("jsonlist", getLogAsJSON());
        return "index";
    }


    @RequestMapping(value = "/insertGuest", method = RequestMethod.GET)
    public String insertNewGuest(ModelMap model,
                                 @RequestParam("firstname") String firstName,
                                 @RequestParam("lastname") String lastName) {
        dao.insertNew(firstName, lastName);
        model.addAttribute("guestlist", dao.getLogAsString());
        return "index";
    }


    @RequestMapping(value = "/gimmeJson", method = RequestMethod.GET)
    @ResponseBody
    public String getLogAsJSON() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Client> guestLog = jdbcTemplate.query("SELECT * FROM guests", new ClientMapper());

        String gsonString = gson.toJson(guestLog);
        return gsonString;
    }
}






