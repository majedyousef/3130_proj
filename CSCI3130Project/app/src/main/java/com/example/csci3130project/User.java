package com.example.csci3130project;

/**
 * The User class is used to create User objects for the application.
 * These objects store user information, such as name and email.
 *
 * @author Group 6, CSCI3130 F21
 */

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public User() {
        firstName = "firstName";
        lastName = "lastName";
        email = "user@gmail.com";
        username = "user123456";
        password = "password1234";
    }

    /**
     * A method for retrieving the user's first name
     * @return a String containing the user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * A method for retrieving the user's first name
     * @return a String containing the user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A method for retrieving the user's email
     * @return a String containing the user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * A method for retrieving the user's username/display name
     * @return a String containing the user's username/display name.
     */
    public String getUsername() {
        return username;
    }

    /**
     * A method for retrieving the user's password
     * @return a String containing the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * A method for updating the user's first name
     * @param fName - String containing new first name
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }
}
