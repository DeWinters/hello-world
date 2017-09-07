package com.springapp.mvc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 09/04/2017.
 */
public class HelloControllerTest {

    @Test
    public void insertNewGuestTest(){
        HelloController hiya = new HelloController();
        String output = hiya.insertNewGuest("Jacki", "Chan");
        Assert.assertEquals(output, "Jacki Change");
    }
}
