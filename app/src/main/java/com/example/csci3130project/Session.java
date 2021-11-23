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
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";
    public Session(Context cntx) {
        pref = cntx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = pref.edit();

    }

    public void saveSession(User user){
        editor.putInt(SESSION_KEY,user.getUserID());

    }
    public int getUser(){
        return pref.getInt(SESSION_KEY,-1);
    }
    public void removeSession(){
        editor.putInt(SESSION_KEY,-1).commit();
    }
    

}
