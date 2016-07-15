package com.springapp.mvc;

/**
 * Created by Derek on 12/07/2016.
 */

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements ParameterizedRowMapper<Item>{

    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setItemId(resultSet.getString("itemId"));
        item.setItemName(resultSet.getString("itemName"));
        item.setItemPrice(resultSet.getLong("itemPrice"));
        return item;
    }
}
