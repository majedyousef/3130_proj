package com.example.csci3130project;
import com.google.android.gms.tasks.Task;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
        databaseReference = database.getReference();
    }

    public Task<Void> add(User user){
        return databaseReference.push().setValue(user);
    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }


}
