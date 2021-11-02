package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //The button in the activity that when clicked sends the user to the search activity.
        Button itemSearch = (Button) findViewById(R.id.searchButton);
        itemSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMainAct = new Intent(MainActivity.this, Search.class);
                startActivity(openMainAct);
            }
        });


    }



}