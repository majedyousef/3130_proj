package com.example.csci3130project;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * The Session class is used to store session data for
 * things like access control.
 *
 * @author Group 6, CSCI3130 F21
 */

public class Session {
    private SharedPreferences pref;

    public Session(Context cntx) {
        pref = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    /**
     * A method for adding a username to the session data
     * @param username - String containing the username
     */
    public void setUsername(String username){
        pref.edit().putString("username", username).commit();
    }

    /**
     * A method for retrieving the username for this session
     * @return a String containing the username
     */
    public String getUserName(){
        String username = pref.getString("username","");
        return username;
    }
    

}
