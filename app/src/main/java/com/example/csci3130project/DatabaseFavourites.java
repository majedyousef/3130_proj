package com.example.csci3130project;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * The DatabaseFavourites class is used to submit a User's
 * favourite categories to the database.
 *
 * @author Group 6, CSCI3130 F21
 */

public class DatabaseFavourites {

    private DatabaseReference databaseReference;

    public DatabaseFavourites() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Favourites");
    }

    /**
     * A method for adding the user's favourite categories to the database
     * @return a void task after adding the favourites
     */
    public Task<Void> addFaves(ArrayList<String> faves) {
        return databaseReference.push().setValue(faves);
    }

}
