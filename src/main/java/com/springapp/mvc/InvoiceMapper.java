package com.springapp.mvc;
        import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class InvoiceMapper implements ParameterizedRowMapper<Invoice> {
    @Override
    public Invoice mapRow(ResultSet resultSet, int i) throws SQLException {Invoice invoice = new Invoice();
        invoice.setId(resultSet.getLong("id"));
        invoice.setInvoiceNum(resultSet.getString("invoice_num"));
        invoice.setClient(resultSet.getString("client"));
        invoice.setDriver(resultSet.getString("driver"));
        invoice.setOrigin(resultSet.getString("origin"));
        invoice.setCollectionTime(resultSet.getString("collection"));
        invoice.setDestination(resultSet.getString("destination"));
        invoice.setDeliveryTime(resultSet.getString("delivery"));
        invoice.setDayTarif(resultSet.getBigDecimal("tarif"));
        invoice.setTaxRate(resultSet.getBigDecimal("tax_rate"));
        invoice.setWaitFee(resultSet.getBigDecimal("wait_fee"));
        invoice.setRetour(resultSet.getBoolean("retour"));
        invoice.setWknd(resultSet.getBoolean("wknd"));
        invoice.setHuman(resultSet.getBoolean("human"));
        invoice.setPrise(resultSet.getBoolean("prise"));
        invoice.setInterne(resultSet.getBoolean("interne"));
        invoice.setAbusive(resultSet.getBoolean("abusive"));
        invoice.setUrgent(resultSet.getBoolean("urgent"));
        invoice.setActive(resultSet.getBoolean("active"));
        invoice.setPaid(resultSet.getBoolean("paid"));
        return invoice;
    }
}

