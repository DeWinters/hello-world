package com.springapp.mvc;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.client.match.MockRestRequestMatchers;

import java.math.BigDecimal;
import java.sql.Timestamp;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Matchers.eq;

public class InvoiceMapperTest {

    @Test
    public void mapRowTest()throws Exception{
        InvoiceMapper invoicemapper = new InvoiceMapper();
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        Mockito.when(mockResultSet.getLong(eq("id"))).thenReturn(9999l);
        Mockito.when(mockResultSet.getString(eq("invoice_num"))).thenReturn("MockInvoice");
        Mockito.when(mockResultSet.getString(eq("client"))).thenReturn("MockClient");
        Mockito.when(mockResultSet.getString(eq("driver"))).thenReturn("MockDriver");
        Mockito.when(mockResultSet.getString(eq("origin"))).thenReturn("MockOrigin");
        Mockito.when(mockResultSet.getString(eq("collection"))).thenReturn("1999-10-10 12:00:00");
        Mockito.when(mockResultSet.getString(eq("destination"))).thenReturn("MockDestination");
        Mockito.when(mockResultSet.getString(eq("delivery"))).thenReturn("2000-1-1 24:24:24");
        Mockito.when(mockResultSet.getBigDecimal(eq("tarif"))).thenReturn(new BigDecimal(65.00));
        Mockito.when(mockResultSet.getBigDecimal(eq("tax_rate"))).thenReturn(new BigDecimal(23.5));
        Mockito.when(mockResultSet.getBigDecimal(eq("wait_fee"))).thenReturn((new BigDecimal(155.00)));
        Mockito.when(mockResultSet.getBoolean(eq("retour"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("wknd"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("human"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("prise"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("interne"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("abusive"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("urgent"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("active"))).thenReturn(true);
        Mockito.when(mockResultSet.getBoolean(eq("paid"))).thenReturn(true);

        Invoice invoice = invoicemapper.mapRow(mockResultSet, 1);

        Mockito.verify(mockResultSet).getLong(eq("id"));
        Mockito.verify(mockResultSet).getString(eq("invoice_num"));
        Mockito.verify(mockResultSet).getString(eq("client"));
        Mockito.verify(mockResultSet).getString(eq("driver"));
        Mockito.verify(mockResultSet).getString(eq("origin"));
        Mockito.verify(mockResultSet).getString(eq("collection"));
        Mockito.verify(mockResultSet).getString(eq("destination"));
        Mockito.verify(mockResultSet).getString(eq("delivery"));
        Mockito.verify(mockResultSet).getBigDecimal(eq("tarif"));
        Mockito.verify(mockResultSet).getBigDecimal(eq("tax_rate"));
        Mockito.verify(mockResultSet).getBigDecimal(eq("wait_fee"));
        Mockito.verify(mockResultSet).getBoolean(eq("retour"));
        Mockito.verify(mockResultSet).getBoolean(eq("wknd"));
        Mockito.verify(mockResultSet).getBoolean(eq("human"));
        Mockito.verify(mockResultSet).getBoolean(eq("prise"));
        Mockito.verify(mockResultSet).getBoolean(eq("interne"));
        Mockito.verify(mockResultSet).getBoolean(eq("abusive"));
        Mockito.verify(mockResultSet).getBoolean(eq("urgent"));
        Mockito.verify(mockResultSet).getBoolean(eq("active"));
        Mockito.verify(mockResultSet).getBoolean(eq("paid"));

        Assert.assertEquals(invoice.getId(), 9999);
        Assert.assertEquals(invoice.getInvoiceNum(), "MockInvoice");
        Assert.assertEquals(invoice.getClient(), "MockClient");
        Assert.assertEquals(invoice.getDriver(), "MockDriver");
        Assert.assertEquals(invoice.getOrigin(), "MockOrigin");
        Assert.assertEquals(invoice.getCollection(), "1999-10-10 12:00:00");
        Assert.assertEquals(invoice.getDestination(), "MockDestination");
        Assert.assertEquals(invoice.getDelivery(), "2000-1-1 24:24:24");
        Assert.assertEquals(invoice.getTarif(), new BigDecimal(65.00));
        Assert.assertEquals(invoice.getTaxRate(), new BigDecimal(23.5));
        Assert.assertEquals(invoice.getWaitFee(), new BigDecimal(155.00));
        Assert.assertEquals(invoice.getRetour(), true);
        Assert.assertEquals(invoice.getWknd(), true);
        Assert.assertEquals(invoice.getHuman(), true);
        Assert.assertEquals(invoice.getPrise(), true);
        Assert.assertEquals(invoice.getInterne(), true);
        Assert.assertEquals(invoice.getAbusive(), true);
        Assert.assertEquals(invoice.getUrgent(), true);
        Assert.assertEquals(invoice.getActive(), true);
        Assert.assertEquals(invoice.getPaid(), true);

        Mockito.verifyNoMoreInteractions(mockResultSet);
    }


    @Test(expected = NullPointerException.class) /** why did i have to change this from sqlexception to nullpointerexception?**/
    public void mapRowTestNullResultSet() throws Exception{
        InvoiceMapper invoiceMapper = new InvoiceMapper();

        invoiceMapper.mapRow(null,1);
    }


}
