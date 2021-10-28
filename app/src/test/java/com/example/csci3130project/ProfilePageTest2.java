package com.example.csci3130project;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import android.app.Activity;
import android.widget.TextView;
import org.junit.runner.RunWith;

import com.example.csci3130project.ui.profile.ProfileFragment;
import com.google.firebase.database.FirebaseDatabase;

public class ProfilePageTest2 {
    static ProfileFragment profileFragment = null;

    String fullNameHolder = "Jane Doe";
    String emailHolder = "janeDoe@outlook.com";
    String userNameHolder ="janeDoe123";

    @BeforeClass
    public static void setup() {
        profileFragment = new ProfileFragment();
    }

    @AfterClass
    public static void tearDown() {
        System.gc();
    }

    //Checks if users name appears on the top of the screen
    @Test
    public void checkIfFullNameIsVisible() {

    }

    //Checks if email appears on the screen
    @Test
    public void checkEmailIsVisible() {

    }

    //Checks if User name appears on the screen
    @Test
    public void checkUserNameIsVisible() {

    }
}
