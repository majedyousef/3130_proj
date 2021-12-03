package com.example.csci3130project;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TradeActivity extends AppCompatActivity {

    ArrayList<Item> myItems = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        // get intents
        String userIDIntent = getIntent().getStringExtra("userID");
        String itemIDIntent = getIntent().getStringExtra("itemID");
        String userNameIntent = getIntent().getStringExtra("userName");
        String itemNameIntent = getIntent().getStringExtra("itemName");
        Integer itemValueIntent = getIntent().getIntExtra("itemValue", 0);
        String itemValue = itemValueIntent.toString();

        // create text views
        TextView tradePartner = findViewById(R.id.viewTradePartner);
        TextView tradeItem = findViewById(R.id.viewTradeItem);
        TextView tradeValue = findViewById(R.id.viewTradeValue);
        Spinner myItemChoice = findViewById(R.id.tradeItemChoice);

        // get user items
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Log.d(TAG, "current user: " + user.getUid());
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference db = firebase.getReference("Items");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()){
                    String name = data.child("name").getValue(String.class);
                    String type = data.child("category").getValue(String.class);
                    String desc = data.child("description").getValue(String.class);
                    String id = data.getKey();
                    String userID = data.child("userID").getValue(String.class);
                    Boolean status = data.child("status").getValue(Boolean.class);
                    Integer itemValue = data.child("itemValue").getValue(Integer.class);

                    Double lat = data.child("latitude").getValue(Double.class);
                    Double lon = data.child("longitude").getValue(Double.class);

                    Item thisItem = new Item(userID, name, desc, type, itemValue, lon, lat, status);

                    Log.d(TAG, "other user: " + userID);

                    if (userID.equals(user.getUid())){
                        myItems.add(thisItem);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Log.d(TAG, "current user: " + myItems);

        // create dropdown
        ArrayAdapter<Item> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, myItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myItemChoice.setAdapter(adapter);

        tradePartner.setText(userNameIntent);
        tradeItem.setText(itemNameIntent);
        tradeValue.setText(itemValue);





    }
}