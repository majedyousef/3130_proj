package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Setting the search text inside of the search bar.
        SearchView searchView = (SearchView) findViewById(R.id.searchfield);
        searchView.setQueryHint("Search for an item!");

    }



}