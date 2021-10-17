package com.example.csci3130project;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.csci3130project.ui.register.RegFragment;

public class RegistrationValidationTests {

    static RegFragment regFragment;

    @BeforeClass
    public static void setup() {
        regFragment = new RegFragment();
    }

    @Test
    public void isEmptyTest() {
        assertTrue(regFragment.isEmpty(""));
        assertFalse(regFragment.isEmpty("Hello"));
    }

}
