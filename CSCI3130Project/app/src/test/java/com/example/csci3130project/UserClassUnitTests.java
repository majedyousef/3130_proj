package com.example.csci3130project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserClassUnitTests {

    User testUser = new User("firstName", "lastName", "user@gmail.com", "user123456", "password1234");
    User testUser2 = new User("John", "Doe", "user_124@outlook.ca", "special_user500", "878456_pass_!");

    @Test
    public void getUserID() {
        assertEquals(1, testUser.getUserID());
        assertEquals(2, testUser2.getUserID());
    }

    @Test
    public void getFirstName() {
        assertEquals("firstName", testUser.getFirstName());
        assertEquals("John", testUser2.getFirstName());
    }

    @Test
    public void setFirstName() {
        testUser.setFirstName("newName");
        assertEquals("newName", testUser.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("lastName", testUser.getLastName());
        assertEquals("Doe", testUser2.getLastName());
    }

    @Test
    public void setLastName() {
        testUser.setLastName("newName");
        assertEquals("newName", testUser.getLastName());
    }

    @Test
    public void getEmail() {
        assertEquals("user@gmail.com", testUser.getEmail());
        assertEquals("user_124@outlook.ca", testUser2.getEmail());
    }

    @Test
    public void setEmail() {
        testUser.setEmail("user@outlook.com");
        assertEquals("user@outlook.com", testUser.getEmail());
    }

    @Test
    public void getUsername() {
        assertEquals("user123456", testUser.getUsername());
        assertEquals("special_user500", testUser2.getUsername());
    }

    @Test
    public void setUsername() {
        testUser.setUsername("123456User");
        assertEquals("123456User", testUser.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("password1234", testUser.getPassword());
        assertEquals("878456_pass_!", testUser2.getPassword());
    }

    @Test
    public void setPassword() {
        testUser.setPassword("Pass_Word123");
        assertEquals("Pass_Word123", testUser.getPassword());
    }

}