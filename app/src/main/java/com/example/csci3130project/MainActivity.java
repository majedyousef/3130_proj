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


        /*SearchFunctionality searchBar = new SearchFunctionality();
        searchBar.createNewSearch(searchView);*/

        CharSequence query = "No query inputted";
        query = searchView.getQuery();

        //Simple Test Textview that is in the activity. Will display the users search keyword
        TextView TextView = (TextView)findViewById(R.id.userSearchKeyword);
        TextView.setText(query);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                TextView.setText("Enter your search keyword!");
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                TextView.setText(query);
                return false;
            }
        });


    }



}