package com.springapp.mvc;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ItemTest {

    private Item objectUnderTest;

    @Before
    public void setUp() throws Exception {
        objectUnderTest = new Item();
    }

    @Test
    public void testSetItemId() throws Exception {
        objectUnderTest.setItemId("testId");
        Assert.assertEquals("testId",objectUnderTest.getItemId());
    }

    @Test
    public void testGetItemId() throws Exception {

    }

    @Test
    public void testSetItemName() throws Exception {
        objectUnderTest.setItemName("itemNameTest");
        Assert.assertEquals("itemNameTest",objectUnderTest.getItemName());
    }

    @Test
    public void testGetItemName() throws Exception {

    }

    @Test
    public void testSetItemPrice() throws Exception {

    }

    @Test
    public void testGetItemPrice() throws Exception {

    }
}