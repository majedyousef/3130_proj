package com.example.csci3130project;

public class Chat {


    private String msg;
    private String userId;
    private String userName;
    private  String recipient;
    public Chat(String msg, String userId, String userName, String recipient){
        this.msg = msg;
        this.userId = userId;
        this.userName = userName;
        this.recipient = recipient;
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
    public  void  setRecipient(String recipient){
        this.recipient= recipient;
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
    public  String getRecipient(){
        return this.recipient;
    }

}

