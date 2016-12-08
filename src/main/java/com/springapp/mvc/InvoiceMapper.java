package com.springapp.mvc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class InvoiceMapper implements ParameterizedRowMapper<Invoice> {
    @Override
    public Invoice mapRow(ResultSet resultSet, int i) throws SQLException {Invoice invoice = new Invoice();
        invoice.setId(resultSet.getLong("id"));
        invoice.setInvoiceNum(resultSet.getString("invoice_num"));
        invoice.setClient(resultSet.getInt("client"));
        invoice.setDriver(resultSet.getInt("driver"));
        invoice.setOrigin(resultSet.getInt("origin"));
        invoice.setDestination(resultSet.getInt("destination"));
        invoice.setRetour(resultSet.getBoolean("retour"));
        invoice.setWknd(resultSet.getBoolean("wknd"));
        invoice.setHuman(resultSet.getBoolean("human"));
        invoice.setPrise(resultSet.getBoolean("prise"));
        invoice.setInterne(resultSet.getBoolean("interne"));
        invoice.setUrgence(resultSet.getBoolean("urgence"));
        invoice.setAbusive(resultSet.getBoolean("abusive"));
        invoice.setCollectionTime(resultSet.getTimestamp("collection_time"));
        invoice.setDeliveryTime(resultSet.getTimestamp("delivery_time"));
        invoice.setDuration(resultSet.getString("duration"));
        invoice.setDayTarif(resultSet.getBigDecimal("tarif_rate"));
        invoice.setTaxRate(resultSet.getBigDecimal("tax_rate"));
        invoice.setTaxes(resultSet.getBigDecimal("tax"));
        invoice.setFare(resultSet.getBigDecimal("fare"));
        invoice.setWaitId(resultSet.getLong("wait"));
        invoice.setWaitFee(resultSet.getBigDecimal("waitFee"));
        return invoice;
    }
}
