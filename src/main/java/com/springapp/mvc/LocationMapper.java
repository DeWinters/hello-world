package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 05/12/2016.
 */
public class LocationMapper implements ParameterizedRowMapper<Location> {
    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
        Location location = new Location();
        location.setLocationId(resultSet.getLong("location_id"));
        location.setLocationName(resultSet.getString("location_name"));

        return location;

    }
}
