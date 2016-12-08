package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 07/12/2016.
 */
public class DriverMapper implements ParameterizedRowMapper<Driver> {
    @Override
    public Driver mapRow(ResultSet resultSet, int i) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getLong("driver_id"));
        driver.setName(resultSet.getString("driver_name"));
        return driver;
    }
}
