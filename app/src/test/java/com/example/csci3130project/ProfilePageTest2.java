package com.example.csci3130project;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import android.app.Activity;

public class ProfilePageTest2 {
    static MainActivity mainActivity;

    @BeforeClass
    public static void setup() {
        mainActivity = new MainActivity();
    }

    @AfterClass
    public static void tearDown() {
        System.gc();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkPasswordChange(){
        assertTrue(!newPassword.equals(oldPassword));
        assertFalse(newPassword.equals(oldPassword));
    }
}
