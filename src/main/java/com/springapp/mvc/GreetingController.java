package com.springapp.mvc;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import java.util.List;

/**
 * Created by Administrator on 06/09/2017.
 */

@RestController
public class GreetingController {


    @Autowired
    private static DriverManagerDataSource dataSauce;

    static Gson gson;





}
