package com.example.csci3130project;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemClassUnitTests {

    Item testItem = new Item();

    @Test
    public void getItemName_Test() {
        assertEquals("itemName", testItem.getName());
    }
}
