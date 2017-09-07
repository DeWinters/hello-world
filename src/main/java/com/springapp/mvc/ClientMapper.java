package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 07/12/2016.
 */
public class ClientMapper implements ParameterizedRowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        if(resultSet == null){
            throw new SQLException("The result set can not be null");
        }
        Client client = new Client();
        client.setId(resultSet.getLong("guest_id"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        return client;
    }
}
