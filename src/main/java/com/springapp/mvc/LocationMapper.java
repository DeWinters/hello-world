package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements ParameterizedRowMapper<Location> {
    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {Location location = new Location();
        location.setId(resultSet.getLong("id"));
        location.setName(resultSet.getString("name"));
        return location;
    }
}
