package com.example.csci3130project;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemClassUnitTests {

    Item testItem = new Item();

    @Test
    public void getItemName_Test() {
        assertEquals("itemName", testItem.getName());
    }

    @Test
    public void getItemDescription_Test() {
        assertEquals("This item is clothing. It is a red shirt size XL", testItem.getDescription());
    }

    @Test
    public void getItemCategory_Test() {
        assertEquals("Clothing", testItem.getCategory());
    }

    @Test
    public void setItemName_Test() {
        testItem.setName("newName");
        assertEquals("newName", testItem.getName());
    }

    @Test
    public void setItemDescription_Test() {
        testItem.setDescription("This item is technology. It's a used iPhone 7.");
        assertEquals("This item is technology. It's a used iPhone 7.", testItem.getDescription());
    }
}
