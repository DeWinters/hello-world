package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 07/12/2016.
 */
public class WaitMapper implements ParameterizedRowMapper<Wait> {
    @Override
    public Wait mapRow(ResultSet resultSet, int i) throws SQLException {
        Wait wait = new Wait();
        wait.setId(resultSet.getLong("wait_id"));
        wait.setName(resultSet.getString("wait_name"));
        wait.setDayRate(resultSet.getBigDecimal("dayRate"));
        wait.setNightRate(resultSet.getBigDecimal("nightRate"));
        wait.setMinutes(resultSet.getLong("minutes"));
        return wait;
    }
}
