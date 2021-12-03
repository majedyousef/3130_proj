package com.example.csci3130project;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReceivedTradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_trade);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference db = firebase.getReference();

        if (user != null){
            TextView theirItem = findViewById(R.id.receivedItemText);
            TextView myItem = findViewById(R.id.sendingItemText);
            TextView differential = findViewById(R.id.receivedTitle3);
            TextView diffNum = findViewById(R.id.receivedTitle4);
            TextView profitLoss = findViewById(R.id.receivedTitle5);

            ArrayList<String> valuation = new ArrayList<String>();
            valuation.add("Very Poor");
            valuation.add("Poor");
            valuation.add("Even");
            valuation.add("Good");
            valuation.add("Very Good");


            db.child("Trades").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot data : snapshot.getChildren()){
                        String otherPersonID = data.child("userID").getValue(String.class);
                        String myID = data.child("partnerID").getValue(String.class);
                        String theirItemID = data.child("itemID").getValue(String.class);
                        String myItemID = data.child("partnerItemID").getValue(String.class);
                        Float theirValue = data.child("itemValue").getValue(Float.class);
                        Float myValue = data.child("partnerItemValue").getValue(Float.class);
                        Integer tradeAccepted = data.child("partnerItemValue").getValue(Integer.class);

                        if (myID.equals(user.getUid())){
                            theirItem.setText(theirItemID);
                            myItem.setText(myItemID);

                            int totalDiff = (int) (theirValue - myValue);
                            String totalDiffStr = Integer.toString(Math.abs(totalDiff));
                            diffNum.setText(totalDiffStr + " $");

                            Log.d(TAG, "My Num " + myValue );
                            Log.d(TAG, "Their num " + theirValue );
                            Log.d(TAG, "The current difference" + (theirValue-myValue) );


                            if (totalDiff < 0){
                                profitLoss.setText("Your Loss Is");
                                Log.d(TAG, "The difference if neg" + (myValue-theirValue)/myValue );
                                if((myValue-theirValue)/myValue >= 0.5){
                                    differential.setText(valuation.get(0));
                                    differential.setTextColor(Color.parseColor("#811331"));
                                }
                                else if((myValue-theirValue)/myValue > 0.25){
                                    differential.setText(valuation.get(1));
                                    differential.setTextColor(Color.parseColor("#C41E3A"));
                                }
                                else if((myValue-theirValue)/myValue <= 0.25){
                                    differential.setText(valuation.get(2));
                                    differential.setTextColor(Color.parseColor("#5F9EA0"));
                                }
                            }
                            else if (totalDiff > 0) {
                                profitLoss.setText("Your Profit Is");
                                Log.d(TAG, "The difference if pos" + (theirValue-myValue)/theirValue );
                                if((theirValue-myValue)/theirValue >= 0.5){
                                    differential.setText(valuation.get(4));
                                    differential.setTextColor(Color.parseColor("#355E3B"));
                                }
                                else if((theirValue-myValue)/theirValue > 0.25){
                                    differential.setText(valuation.get(3));
                                    differential.setTextColor(Color.parseColor("#097969"));
                                }
                                else if((theirValue-myValue)/theirValue <= 0.25){
                                    differential.setText(valuation.get(2));
                                    differential.setTextColor(Color.parseColor("#5F9EA0"));
                                }
                            }
                            else {
                                profitLoss.setText("The Values Are Equal");
                                differential.setText(valuation.get(2));
                                differential.setTextColor(Color.parseColor("#5F9EA0"));
                            }
                        }


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
    }
}