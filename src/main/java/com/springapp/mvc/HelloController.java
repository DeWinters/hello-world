package com.springapp.mvc;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//nope import org.springframework.web.bind.annotation.CrossOrigin;



@Controller
public class HelloController {

    @Autowired
    private DriverManagerDataSource dataSauce;

    public void setDataSauce(DriverManagerDataSource dataSauce) {
        this.dataSauce = dataSauce;
    }

    @Autowired
    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    Gson gson = new Gson();

    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        model.addAttribute("guestlist", dao.getLogAsString());
        return "index";
    }


    @RequestMapping(value = "/insertGuest", method = RequestMethod.POST)
    public String insertNewGuest(ModelMap model,
                                 @RequestParam("firstname") String firstName,
                                 @RequestParam("lastname") String lastName) {
        dao.insertNew(firstName, lastName);
        model.addAttribute("guestlist", dao.getLogAsString());
        return "index";
    }


    public String getLogAsJSON() {
        return dao.getGuestLog();
    }
    */


}






