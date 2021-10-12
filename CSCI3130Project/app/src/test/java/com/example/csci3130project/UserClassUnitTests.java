package com.example.csci3130project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserClassUnitTests {

    User testUser = new User("firstName");
    User testUser2 = new User("John");

    @Test
    public void getUserID() {
        int expected = 1;
        assertEquals(expected, testUser.getUserID());
    }

    @Test
    public void getFirstName() {
        assertEquals("firstName", testUser.getFirstName());
        assertEquals("John", testUser2.getFirstName());
    }

    @Test
    public void setFirstName() {
        String newData = "newName";
        testUser.setFirstName(newData);
        assertEquals(newData, testUser.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("lastName", testUser.getLastName());
        assertEquals("Doe", testUser.getLastName());
    }

    @Test
    public void setLastName() {
        String newData = "newName";
        testUser.setLastName(newData);
        assertEquals(newData, testUser.getLastName());
    }

    @Test
    public void getEmail() {
        String expected = "user@gmail.com";
        assertEquals(expected, testUser.getEmail());
    }

    @Test
    public void setEmail() {
        String newData = "user@outlook.com";
        testUser.setEmail(newData);
        assertEquals(newData, testUser.getEmail());
    }

    @Test
    public void getUsername() {
        String expected = "user123456";
        assertEquals(expected, testUser.getUsername());
    }

    @Test
    public void setUsername() {
        String newData = "123456User";
        testUser.setUsername(newData);
        assertEquals(newData, testUser.getUsername());
    }

    @Test
    public void getPassword() {
        String expected = "password1234";
        assertEquals(expected, testUser.getPassword());
    }

    @Test
    public void setPassword() {
        String newData = "Pass_Word123";
        testUser.setPassword(newData);
        assertEquals(newData, testUser.getPassword());
    }

}