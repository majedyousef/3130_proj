package com.example.csci3130project;


/**
 * The Item class is used to create Item objects for the application.
 * These objects store information about goods that are posted for trading.
 *
 * @author Group 6, CSCI3130 F21
 */

public class Item {

    private String userID;
    private String name;
    private String description;
    private String category;
<<<<<<< HEAD
    private int itemID;
    private int userID;
    private static int count = 0;
    private int itemValue;
    private double longitude;
    private double latitude;


    public Item() {
        count++;
        itemID = count;
=======

    private int itemValue;
    private double longitude;
    private double latitude;


    public Item(String userID, String name, String description, String category, Integer itemValue, double longitude, double latitude) {

        this.userID = userID;
        this.name = name;
        this.description = description;
        this.category = category;
        this.itemValue = itemValue;
        this.longitude = longitude;
        this.latitude = latitude;

>>>>>>> total_refactor
    }


    public String getUserID() {
        return this.userID;
    }

    /**
     * A method for retrieving the name of an item
     *
     * @return a String containing the name of this item
     */
    public String getName() {
        return this.name;
    }

    /**
     * A method for retrieving the description of an item
     *
     * @return a String containing the description of this item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * A method for retrieving the category of an item (ex. clothing, furniture)
     *
     * @return a String containing the category of this item
     */
    public String getCategory() {
        return this.category;
    }

    public double getItemValue() {
        return this.itemValue;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }


    /**
     * A method for retrieving the value of an item
     * @return a double containing the value of this item
     */
    public double getItemValue(){
        return this.itemValue;
    }

    /**
     * A method for retrieving the longitude of an item
     * @return a double containing the longitude of this item
     */
    public double getLongitude(){
        return this.longitude;
    }

    /**
     * A method for retrieving the latitude of an item
     * @return a double containing the latitude of this item
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * A method for updating the item's name
     *
     * @param name - String containing new item name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * A method for updating the item's description
     *
     * @param description - String containing new item description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * A method for updating the item's category
     *
     * @param category - String containing new item category
     */
    public void setCategory(String category) {
        this.category = category;
    }

<<<<<<< HEAD
    /**
     * A method for updating the item's value
     * @param itemValue - int containing new item value
     */
    public void setItemValue(int itemValue){
        this.itemValue = itemValue;
    }

    /**
     * A method for updating the item's longitude
     * @param longitude - double containing new item longitude
     */
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    /**
     * A method for updating the item's latitude
     * @param latitude - double containing new item latitude
     */
    public void setLatitude(double latitude){
=======
    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
>>>>>>> total_refactor
        this.latitude = latitude;
    }
}
