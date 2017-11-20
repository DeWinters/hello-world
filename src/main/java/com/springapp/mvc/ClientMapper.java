package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements ParameterizedRowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {Client client = new Client();
        client.setId(resultSet.getLong("id"));
        client.setName(resultSet.getString("name"));
        return client;
    }
}
