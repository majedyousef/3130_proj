package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SetFavourites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_favourites);

        ArrayList<String> favourites = new ArrayList<String>();

        Button confirmButton = findViewById(R.id.confirmButton);

        // Confirm the user's choice of favourite categories
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}