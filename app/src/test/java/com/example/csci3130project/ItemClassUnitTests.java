package com.example.csci3130project;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemClassUnitTests {

    String description = "This item is clothing. It is a red shirt size XL";
    Item testItem = new Item("itemName", description, "Clothing");

    String description2 = "This item is furniture. It is a used couch";
    Item testItem2 = new Item("itemName2", description2, "Furniture");

    @Test
    public void getItemName_Test() {
        assertEquals("itemName", testItem.getName());
        assertEquals("itemName2", testItem2.getName());
    }

    @Test
    public void getItemDescription_Test() {
        assertEquals("This item is clothing. It is a red shirt size XL", testItem.getDescription());
        assertEquals("This item is furniture. It is a used couch", testItem2.getDescription());
    }

    @Test
    public void getItemCategory_Test() {
        assertEquals("Clothing", testItem.getCategory());
        assertEquals("Furniture", testItem2.getCategory());
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

    @Test
    public void setItemCategory_Test() {
        testItem.setCategory("Technology");
        assertEquals("Technology", testItem.getCategory());
    }

    @Test
    public void getItemID_Test() {
        assertEquals(0, testItem.getItemID());
        assertEquals(1, testItem.getItemID());
    }
}
