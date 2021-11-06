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
    private int itemID;
    private int userID;
    private static int count = 0;
    private int itemValue;
    private double longitude;
    private double latitude;

    public Item(String name, String description, String category,int itemValue, double longitude, double latitude) {
        this.name = name;
        this.description = description;
        this.category = category;
        count++;
        itemID = count;
        this.itemValue = itemValue;
        this.longitude =longitude;
        this.latitude = latitude;
    }

    /**
     * A method for retrieving the item's unique ID
     * @return an integer representing the item's ID
     */
    public int getItemID() {
        return itemID;
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

    public double getItemValue(){
        return this.itemValue;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public double getLatitude(){
        return latitude;
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
    public void setItemValue(int itemValue){
        this.itemValue =itemValue;
    }
    private void setLongitude(double longitude){
        this.longitude = longitude;
    }
    private void setLatitude(double latitude){
        this.latitude = latitude;
    }
}
