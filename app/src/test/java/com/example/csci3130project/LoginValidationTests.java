package com.example.csci3130project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.csci3130project.ui.login.LoginFragment;

import org.junit.BeforeClass;
import org.junit.Test;

public class LoginValidationTests {

    static LoginFragment logFragment;

    @BeforeClass
    public static void setup() {
        logFragment = new LoginFragment();
    }

    @Test
    public void isEmailEmptyTest() {
        assertTrue(logFragment.isEmailEmpty(""));
        assertFalse(logFragment.isEmailEmpty("123"));
    }
}
