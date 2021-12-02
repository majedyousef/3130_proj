package com.example.csci3130project;

public class TradeRequest {

    private String userID;
    private String tradeID;
    private String itemID;
    private String tradeItemID;
    private String itemValue;
    private String tradeItemValue;

    private boolean tradeAccepted;

    public TradeRequest(String userID, String tradeID, String itemID, String tradeItemID, String itemValue, String tradeItemValue, boolean tradeAccepted) {
        this.userID = userID;
        this.tradeID = tradeID;
        this.itemID = itemID;
        this.tradeItemID = tradeItemID;
        this.itemValue = itemValue;
        this.tradeItemValue = tradeItemValue;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getTradeItemID() {
        return tradeItemID;
    }

    public void setTradeItemID(String tradeItemID) {
        this.tradeItemID = tradeItemID;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getTradeItemValue() {
        return tradeItemValue;
    }

    public void setTradeItemValue(String tradeItemValue) {
        this.tradeItemValue = tradeItemValue;
    }

    public boolean isTradeAccepted() {
        return tradeAccepted;
    }

    public void setTradeAccepted(boolean tradeAccepted) {
        this.tradeAccepted = tradeAccepted;
    }
}
