package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverMapper implements ParameterizedRowMapper<Driver> {
    @Override
    public Driver mapRow(ResultSet resultSet, int i) throws SQLException {Driver driver = new Driver();
        driver.setId(resultSet.getLong("id"));
        driver.setClearance(resultSet.getInt("clearance"));
        driver.setFirstName(resultSet.getString("first_name"));
        driver.setLastName(resultSet.getString("last_name"));
        return driver;
    }
}
