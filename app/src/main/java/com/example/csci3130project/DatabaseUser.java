package com.example.csci3130project;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * The DatabaseUser class is used to connect User objects to the database.
 * Users can be added, removed, or have their info updated.
 *
 * @author Group 6, CSCI3130 F21
 */

public class DatabaseUser {

    private DatabaseReference databaseReference;

    public DatabaseUser() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(User.class.getSimpleName());
    }

    /**
     * A method for adding a user to the database with a unique ID
     * @return a void task after adding the user
     */
    public Task<Void> addUser(User user) {
        return databaseReference.child(String.valueOf(user.getUserID())).setValue(user);
    }
}
