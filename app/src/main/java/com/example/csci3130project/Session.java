package com.example.csci3130project;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences pref;


    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        pref = PreferenceManager.getDefaultSharedPreferences(cntx);
    }
    public void setUsername(String username){
        pref.edit().putString("username", username).commit();
    }
    public String getUserName(){
        String username = pref.getString("username","");
        return username;
    }
    

}
