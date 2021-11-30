package com.example.csci3130project;

public class Chat {


    private String msg;
    private String userId;
    private String userName;
    private  String recipientId;
    private String recipientName;
    public Chat(String msg, String userId, String userName, String recipientId,String recipientName ){
        this.msg = msg;
        this.userId = userId;
        this.userName = userName;
        this.recipientId = recipientId;
        this.recipientName =recipientName;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setRecipientId(String recipient){
        this.recipientId= recipient;
    }
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    public String getMsg() {
        return msg;
    }
    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
    public  String getRecipientId(){
        return this.recipientId;
    }

    public String getRecipientName() {
        return recipientName;
    }


}

