package com.example.csci3130project;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        String userIDIntent = getIntent().getStringExtra("userID");
        String itemIDIntent = getIntent().getStringExtra("itemID");
        String userNameIntent = getIntent().getStringExtra("userName");
        String itemNameIntent = getIntent().getStringExtra("itemName");
        Integer itemValueIntent = getIntent().getIntExtra("itemValue", 0);
        String itemValue = itemValueIntent.toString();

        TextView tradePartner = findViewById(R.id.viewTradePartner);
        TextView tradeItem = findViewById(R.id.viewTradeItem);
        TextView tradeValue = findViewById(R.id.viewTradeValue);

        tradePartner.setText(userNameIntent);
        tradeItem.setText(itemNameIntent);
        tradeValue.setText(itemValue);
    }
}