package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        String userIDIntent = getIntent().getStringExtra("userID");
        String itemIDIntent = getIntent().getStringExtra("itemID");
        String itemValueIntent = getIntent().getStringExtra("itemValue");



    }
}