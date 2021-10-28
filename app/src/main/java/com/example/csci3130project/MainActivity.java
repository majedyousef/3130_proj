package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //This is just a simple method that can be commented in or out based on if the search data and stuff needs to be there.
        //Just for my testing so it isnt all piled here in the main onCreate method. The method can be moved around anytime
        createSearchBar();


    }

    private void createSearchBar() {
        // Creating the searchview and listeview object by finding the searchview and listview from the uI.
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);
        //creating an array to store the name of items that are available (in the future maybe database title reference etc?) and adding some dummy data
        list = new ArrayList<>();
        list.add("Used Office Chair for trade");
        list.add("New Set of Kitchenware");
        list.add("Like New Airpods");
        list.add("Used Gaming PC");
        list.add("Yard Equipment");
        list.add("School Supplies");
        list.add("Non Perishable Foods");
        list.add("Books");
        list.add("Used Kids Clothes");
        list.add("Test 1");
        list.add("Test 2");
        list.add("Test 3");
        list.add("Test 4");
        list.add("Test 5");
        list.add("Test 6");


        //Creating a adapter for the listview and a on query text listener that will listen to the changes in the text view
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //This method is performed when the user clicks the enter button and "submits" the text. this can be modified to do other things
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (list.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            //This is the method that takes in the text as the user is typing and calls the filter method to see if there are items available regarding what the user is typing.
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }


}