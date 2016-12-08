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
        Client client = new Client();
        client.setId(resultSet.getLong("client_id"));
        client.setName(resultSet.getString("client_name"));
        return client;
    }
}