package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 03/09/2017.
 */
public class GuestLog {

    @Autowired
    private DriverManagerDataSource dataSauce;

    public List<Client> getLogAsList() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<Client> guestLog = jdbcTemplate.query("SELECT * FROM guests", new ClientMapper());
        return guestLog;
    }

    public String getLogAsString() {
        String allGuests ="blah";
        return allGuests;
    }

    public void insertNew(String firstName, String lastName){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);    /** Send compiled invoice data to the database **/
        jdbcTemplate.update("INSERT INTO guests(first_name,last_name)" +
                "VALUES(?,?)", firstName, lastName);
    }
}
