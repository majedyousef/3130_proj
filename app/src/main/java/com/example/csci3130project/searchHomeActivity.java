package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class searchHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_home);

        Button confirmButton = findViewById(R.id.searchConfBtn);

        // Retrieve category checkboxes
        CheckBox category1 = findViewById(R.id.searchCategory1);
        CheckBox category2 = findViewById(R.id.searchCategory2);
        CheckBox category3 = findViewById(R.id.searchCategory3);
        CheckBox category4 = findViewById(R.id.searchCategory4);
        CheckBox category5 = findViewById(R.id.searchCategory5);
        CheckBox category6 = findViewById(R.id.searchCategory6);
        CheckBox category7 = findViewById(R.id.searchCategory7);

        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                i.putExtra("category", category1.getText().toString());
            }
        });

        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                i.putExtra("category", category2.getText().toString());
            }
        });

        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                i.putExtra("category", category3.getText().toString());
            }
        });

        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                i.putExtra("category", category4.getText().toString());
            }
        });

        category5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                i.putExtra("category", category5.getText().toString());
            }
        });

        category6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                i.putExtra("category", category6.getText().toString());
            }
        });

        category7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                i.putExtra("category", category7.getText().toString());
            }
        });
    }
}