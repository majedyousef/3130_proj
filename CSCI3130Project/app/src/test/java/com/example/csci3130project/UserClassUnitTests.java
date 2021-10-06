package com.example.csci3130project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserClassUnitTests {

    User testUser = new User();

    @Test
    public void getFirstName() {
        String expected = "firstName";
        assertEquals(expected, testUser.getFirstName());
    }

}