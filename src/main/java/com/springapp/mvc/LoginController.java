package com.springapp.mvc;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.util.List;

/**
 * Created by Administrator on 27/11/2016.
 */
@Controller
public class LoginController {
    @Autowired
    private DriverManagerDataSource dataSauce;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyUser(ModelMap model, @RequestParam("username") String username,@RequestParam("password") String password) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<User> allUsers = jdbcTemplate.query("SELECT * FROM USER where user_name =?", new UserMapper(),username);

       if(allUsers.isEmpty()){
           model.addAttribute("error", "invalid Entry");

       } else if (allUsers.size() == 1){
           String pw = DigestUtils.md5Hex(password);
           String key = allUsers.get(0).getPassKey();
           if (pw.equalsIgnoreCase(key)){

               String locationList = null;
               JdbcTemplate jdbcTemp = new JdbcTemplate(dataSauce);
               List<Location> allLocations = jdbcTemp.query("SELECT * FROM LOCATION", new LocationMapper());

               for(Location location : allLocations){
                   locationList += "<option value=\"" + location.getLocationId() + "\">" + location.getLocationName() + "</option>";
               }
               model.addAttribute("boxedLocations", locationList);
               return "invoice";
           }
       } else {
           model.addAttribute("error", "Duplicate Match Error");
       }

        return "index";
    }
}

