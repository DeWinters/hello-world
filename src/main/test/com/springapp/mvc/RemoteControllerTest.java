package com.springapp.mvc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.math.BigDecimal;

import static org.mockito.Matchers.eq;

public class RemoteControllerTest {

    private RemoteController remoteController;

    private DriverManagerDataSource mockDataSauce;

    private DAO mockDao;

    @Before
    public void setup(){
        remoteController = new RemoteController();
        mockDataSauce = Mockito.mock(DriverManagerDataSource.class);
        mockDao = Mockito.mock(DAO.class);
        remoteController.setDao(mockDao);
        remoteController.setDataSauce(mockDataSauce);
    }

    @Test
    public void testGetInvoiceListAsJson() throws Exception{
        Mockito.when(mockDao.getInvoiceList()).thenReturn("MOCK RETURN VALUE");
        String jsonReturned = remoteController.getInvoiceListAsJSON();
        Mockito.verify(mockDao).getInvoiceList();
        Assert.assertEquals(mockDao.getInvoiceList(), jsonReturned);
    }
    @Test
    public void testGetInvoiceListAsJson_NullResultSet() throws Exception{
        Mockito.when(mockDao.getInvoiceList()).thenReturn(null);
        String jsonReturned = remoteController.getInvoiceListAsJSON();
        Mockito.verify(mockDao).getInvoiceList();
        Assert.assertEquals(mockDao.getInvoiceList(), jsonReturned);
    }

    @Test
    public void testGetActivesListAsJson() throws Exception{
        Mockito.when(mockDao.getActivesList()).thenReturn("MOCK RETURN VALUE");
        String jsonReturned = remoteController.getActivesListAsJSON();
        Mockito.verify(mockDao).getActivesList();
        Assert.assertEquals(mockDao.getActivesList(), jsonReturned);
    }
    @Test
    public void testGetActivesListAsJson_NullResultSet() throws Exception{
        Mockito.when(mockDao.getActivesList()).thenReturn(null);
        String jsonReturned = remoteController.getActivesListAsJSON();
        Mockito.verify(mockDao).getActivesList();
        Assert.assertEquals(mockDao.getActivesList(), jsonReturned);
    }

    @Test
    public void FIX_ME_testNewInvoice() throws Exception{
        Invoice invoice = new Invoice();
        //invoice.setId(9999);
        invoice.setInvoiceNum("testInvoice");
        invoice.setClient("testClient");
        invoice.setDriver("testDriver");
        invoice.setOrigin("testOrigin");
        invoice.setCollectionTime("1997-4-4 12:12:12");
        invoice.setDestination("testDestination");
        invoice.setDeliveryTime("1998-6-6 24:24:24");
        invoice.setDayTarif(new BigDecimal(15.00));
        invoice.setTaxRate(new BigDecimal(13.00));
        invoice.setWaitFee(new BigDecimal(75.50));
        invoice.setRetour(true);
        invoice.setWknd(true);
        invoice.setHuman(true);
        invoice.setPrise(true);
        invoice.setInterne(true);
        invoice.setAbusive(true);
        invoice.setUrgent(true);
        invoice.setPaid(true);

        /*
        Mockito.when(mockDao.newInvoice(invoice)).thenReturn();
        String jsonReturned = remoteController.getActivesListAsJSON();
        Mockito.verify(mockDao).getActivesList();
        Assert.assertEquals(mockDao.getActivesList(), jsonReturned);
        */
    }

    //update invoice

    //delete invoice

}
