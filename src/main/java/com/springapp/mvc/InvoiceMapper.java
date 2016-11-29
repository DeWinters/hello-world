package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class InvoiceMapper implements ParameterizedRowMapper<Invoice> {
    @Override
    public Invoice mapRow(ResultSet resultSet, int i) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(resultSet.getLong("id"));
        invoice.setInvoiceNum(resultSet.getString("invoice_num"));
        invoice.setClient(resultSet.getString("client"));
        invoice.setDriver(resultSet.getString("driver"));
        invoice.setOrigin(resultSet.getString("origin"));
        invoice.setDestination(resultSet.getString("destination"));
        invoice.setRetour(resultSet.getBoolean("retour"));
        invoice.setWknd(resultSet.getBoolean("wknd"));
        invoice.setHuman(resultSet.getBoolean("human"));
        invoice.setPrise(resultSet.getBoolean("prise"));
        invoice.setInterne(resultSet.getBoolean("interne"));
        invoice.setUrgence(resultSet.getBoolean("urgence"));
        invoice.setAbusive(resultSet.getBoolean("abusive"));
        invoice.setDateStamp(resultSet.getDate("date_stamp"));
        return invoice;
    }
}
