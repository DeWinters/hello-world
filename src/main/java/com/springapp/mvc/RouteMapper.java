package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 06/12/2016.
 */
public class RouteMapper implements ParameterizedRowMapper<Route> {
    @Override
    public Route mapRow(ResultSet resultSet, int i) throws SQLException {
        Route route = new Route();
        route.setId(resultSet.getLong("route_id"));
        route.setOrigin(resultSet.getInt("id_origin"));
        route.setDestination(resultSet.getInt("id_destined"));
        route.setDayTarif(resultSet.getBigDecimal("day_tarif"));
        route.setNightTarif(resultSet.getBigDecimal("night_tarif"));

        return route;
    }
}
