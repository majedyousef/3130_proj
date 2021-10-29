package com.example.csci3130project;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * The DatabaseItem class is used to connect Item objects to the database.
 * Items can be added, removed, or have their info updated.
 *
 * @author Group 6, CSCI3130 F21
 */

public class DatabaseItem {

    private DatabaseReference databaseReference;

    public DatabaseItem() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(Item.class.getSimpleName());
    }

    /**
     * A method for adding an item to the database
     * @return a void task after adding the item
     */
    public Task<Void> addItem(Item item) {
        return databaseReference.push().setValue(item);
    }
}
