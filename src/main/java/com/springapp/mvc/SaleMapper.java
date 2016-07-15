package com.springapp.mvc;

/**
 * Created by Derek on 12/07/2016.
 */

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMapper implements ParameterizedRowMapper<Sale>{

    @Override
    public Sale mapRow(ResultSet resultSet, int i) throws SQLException {
        Sale sale = new Sale();
        sale.setInvoice(resultSet.getInt("invoice"));
        sale.setItemId(resultSet.getString("itemId"));
        sale.setMemberId(resultSet.getLong("memberId"));
        sale.setPrice(resultSet.getLong("price"));
        sale.setDate(resultSet.getString("date"));
        return sale;
    }
}

