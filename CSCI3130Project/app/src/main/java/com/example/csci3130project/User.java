package com.example.csci3130project;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String username;

    public User() {
        firstName = "firstName";
        lastName = "lastName";
        email = "user@gmail.com";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
