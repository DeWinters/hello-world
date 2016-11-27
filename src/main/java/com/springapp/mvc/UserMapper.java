package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class UserMapper implements ParameterizedRowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setAge(resultSet.getInt("age"));

        user.setInvoiceNum(resultSet.getString("invoice_num"));
        user.setClient(resultSet.getString("client"));
        user.setDriver(resultSet.getString("driver"));
        user.setOrigin(resultSet.getString("origin"));
        user.setDestination(resultSet.getString("destination"));
        user.setRetour(resultSet.getBoolean("retour"));
        user.setWknd(resultSet.getBoolean("wknd"));
        user.setHuman(resultSet.getBoolean("human"));
        user.setPrise(resultSet.getBoolean("prise"));
        user.setInterne(resultSet.getBoolean("interne"));
        user.setUrgence(resultSet.getBoolean("urgence"));
        user.setAbusive(resultSet.getBoolean("abusive"));
       // user.setDateStamp(resultSet.getDate("date_stamp"));
        return user;
    }
}
