package com.example.csci3130project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference db = firebase.getReference();
        String userID = db.child("Users").child(user.getUid()).getKey();

        TextView accountProfit = findViewById(R.id.accountDetail);
        accountProfit.setText("Empty");
        TextView itemsSold = findViewById(R.id.itemSoldDetail);
        itemsSold.setText("No items sold!");


        if (user != null) {

            TextView nameBox = findViewById(R.id.fullNameTextTrans);
            TextView emailBox = findViewById(R.id.emailTextTrans);
            TextView userNameBox = findViewById(R.id.userNameTextTrans);

            db.child("Users").child(user.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot data) {
                    String fName = data.child("firstName").getValue(String.class);
                    String lName = data.child("lastName").getValue(String.class);
                    String fullName = fName + " " + lName;
                    String userName = data.child("username").getValue(String.class);
                    String email = data.child("email").getValue(String.class);
                    nameBox.setText(fullName);
                    emailBox.setText(email);
                    userNameBox.setText(userName);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Items");
        ArrayList<Item> itemsSoldList = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot adSnapshot: snapshot.getChildren()){
                    String name = adSnapshot.child("name").getValue(String.class);
                    String category = adSnapshot.child("category").getValue(String.class);
                    String userID = adSnapshot.child("userID").getValue(String.class);
                    String description = adSnapshot.child("description").getValue(String.class);
                    Double lat = adSnapshot.child("latitude").getValue(Double.class);
                    Double lon = adSnapshot.child("longitude").getValue(Double.class);
                    Integer itemValue = adSnapshot.child("itemValue").getValue(Integer.class);
                    Boolean status = adSnapshot.child("status").getValue(Boolean.class);
                    Item item = new Item(userID,name,description,category,itemValue,lon,lat,status);
                    if (item.getStatus() && (userID.equals(item.getUserID()))) {
                        String holder = "Added to sold list";
                        Log.v("Item was added", holder);
                        itemsSoldList.add(item);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
    /**
     * A method for calculating profit made on account
     */
    public static Integer profitMade(ArrayList<Item> holder){
        int sum = 0;
        for (int i = 0; i < holder.size(); i++){
            sum += holder.get(i).getItemValue();
        }
        return sum;
    }
}