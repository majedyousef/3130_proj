package com.example.csci3130project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        String itemIDIntent = getIntent().getStringExtra("snippet");

        TextView itemID = findViewById(R.id.itemID);
        itemID.setText(itemIDIntent);

        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference db = firebase.getReference();

        TextView nameBox = findViewById(R.id.itemName);
        TextView typeBox = findViewById(R.id.itemType);
        TextView valueBox = findViewById(R.id.itemValue);
        TextView descBox = findViewById(R.id.itemDesc);
        TextView userBox = findViewById(R.id.itemUser);

        db.child("Items").child(itemIDIntent).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot data) {
                String category = data.child("category").getValue(String.class);
                String description =  data.child("description").getValue(String.class);
                Integer value = data.child("itemValue").getValue(Integer.class);
                String name =  data.child("name").getValue(String.class);
                String userID = data.child("userID").getValue(String.class);

                db.child("Users").child(userID).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String userFName = snapshot.child("firstName").getValue(String.class);
                        String userLName = snapshot.child("lastName").getValue(String.class);
                        String fullName = userFName + " " + userLName;

                        nameBox.setText(name);
                        typeBox.setText(category);
                        valueBox.setText(value.toString());
                        descBox.setText(description);
                        userBox.setText(fullName);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}