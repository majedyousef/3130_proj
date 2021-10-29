package com.example.csci3130project;

/**
 * The Item class is used to create Item objects for the application.
 * These objects store information about goods that are posted for trading.
 *
 * @author Group 6, CSCI3130 F21
 */

public class Item {

    private String name;
    private String description;
    private String category;

    public Item(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    /**
     * A method for retrieving the name of an item
     * @return a String containing the name of this item
     */
    public String getName() {
        return name;
    }

    /**
     * A method for retrieving the description of an item
     * @return a String containing the description of this item
     */
    public String getDescription() {
        return description;
    }

    /**
     * A method for retrieving the category of an item (ex. clothing, furniture)
     * @return a String containing the category of this item
     */
    public String getCategory() {
        return category;
    }

    /**
     * A method for updating the item's name
     * @param name - String containing new item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method for updating the item's description
     * @param description - String containing new item description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * A method for updating the item's category
     * @param category - String containing new item category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}