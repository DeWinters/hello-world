package com.springapp.mvc;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Matchers.eq;

public class ClientMapperTest {

    @Test
    public void mapRowTest()throws Exception{
        ClientMapper clientmapper = new ClientMapper();
        //clientmapper.setConnection("this is the fake string");
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        Mockito.when(mockResultSet.getLong(eq("guest_id"))).thenReturn(1l);
        Mockito.when(mockResultSet.getString(eq("first_name"))).thenReturn("Fred");
        Mockito.when(mockResultSet.getString(eq("last_name"))).thenReturn("Savage");

        Client client = clientmapper.mapRow(mockResultSet, 1);

        Mockito.verify(mockResultSet).getLong(eq("guest_id"));
        Mockito.verify(mockResultSet).getString(eq("first_name"));
        Mockito.verify(mockResultSet).getString(eq("last_name"));

        Assert.assertEquals(client.getId(), 1);
        Assert.assertEquals(client.getFirstName(), "Fred");
        Assert.assertEquals(client.getLastName(), "Savage");

        Mockito.verifyNoMoreInteractions(mockResultSet);
    }

    @Test(expected = SQLException.class)
    public void mapRowTestNullResultSet() throws Exception{
        ClientMapper clientMapper = new ClientMapper();

        clientMapper.mapRow(null,1);
    }
}
