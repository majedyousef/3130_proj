package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        //Search bar code & Functionality -
        //Setting the search text inside of the search bar.
        SearchView searchView = (SearchView) findViewById(R.id.searchfield);
        searchView.setQueryHint("Search for an item!");

        CharSequence query = "No query inputted";
        query = searchView.getQuery();

        //Simple Test Textview that is in the activity. Will display the users search keyword
        TextView SearchKeyword = (TextView)findViewById(R.id.userSearchKeyword);

        SearchKeyword.setText("Enter your search keyword!");
        TextView SearchKeyword2 = (TextView)findViewById(R.id.queryResult);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                SearchKeyword.setText("Enter your search keyword!");
                SearchKeyword2.setText("No Keyword Entered");
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchKeyword.setText("You searched for: " + query);
                SearchKeyword2.setText("User Query Keyword: " + query);
                return false;
            }
        });


    }



}