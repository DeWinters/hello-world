package com.springapp.mvc;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 07/09/2017.
 */
@Service
public class DAO {

    @Autowired
    private DriverManagerDataSource dataSauce;

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
