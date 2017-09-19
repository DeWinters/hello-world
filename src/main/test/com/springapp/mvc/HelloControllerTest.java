package com.springapp.mvc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.mockito.Matchers.eq;

/**
 * Created by Administrator on 09/04/2017.
 */
public class HelloControllerTest {

    private HelloController helloController;

    private DriverManagerDataSource mockDataSauce;

    private DAO mockDao;

    @Before
    public void setup(){
        helloController = new HelloController();
        mockDataSauce = Mockito.mock(DriverManagerDataSource.class);
        mockDao = Mockito.mock(DAO.class);
        helloController.setDao(mockDao);
        helloController.setDataSauce(mockDataSauce);
    }


    @Test
    public void testGetLogAsJson() throws Exception{
        Mockito.when(mockDao.getGuestLog()).thenReturn("THIS IS THE RETURN VALUE");

        String jsonReturned = helloController.getLogAsJSON();

        Mockito.verify(mockDao).getGuestLog();
        Mockito.verify(mockDao).bullshit(eq("fdas"),eq("fdas"));
        Mockito.verifyNoMoreInteractions(mockDao);
    }
}
