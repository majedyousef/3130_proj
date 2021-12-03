package com.example.csci3130project;

public class TradeRequest {

    private String userID;
    private String partnerID;
    private String itemID;
    private String partnerItemID;
    private Integer itemValue;
    private Integer partnerItemValue;
    private Integer tradeAccepted;

    public TradeRequest(String userID, String partnerID, String itemID, String partnerItemID, Integer itemValue, Integer partnerItemValue, Integer tradeAccepted) {
        this.userID = userID;
        this.partnerID = partnerID;
        this.itemID = itemID;
        this.partnerItemID = partnerItemID;
        this.itemValue = itemValue;
        this.partnerItemValue = partnerItemValue;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getPartnerItemID() {
        return partnerItemID;
    }

    public void setPartnerItemID(String partnerItemID) {
        this.partnerItemID = partnerItemID;
    }

    public Integer getItemValue() {
        return itemValue;
    }

    public void setItemValue(Integer itemValue) {
        this.itemValue = itemValue;
    }

    public Integer getPartnerItemValue() {
        return partnerItemValue;
    }

    public void setPartnerItemValue(Integer partnerItemValue) {
        this.partnerItemValue = partnerItemValue;
    }

    public Integer isTradeAccepted() {
        return tradeAccepted;
    }

    public void setTradeAccepted(Integer tradeAccepted) {
        this.tradeAccepted = tradeAccepted;
    }
}
