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

    @Test
    public void getLastName() {
        String expected = "lastName";
        assertEquals(expected, testUser.getLastName());
    }

    @Test
    public void getEmail() {
        String expected = "user@gmail.com";
        assertEquals(expected, testUser.getEmail());
    }

    @Test
    public void getUsername() {
        String expected = "user123456";
        assertEquals(expected, testUser.getUsername());
    }

    @Test
    public void getPassword() {
        String expected = "password1234";
        assertEquals(expected, testUser.getUsername());
    }

}