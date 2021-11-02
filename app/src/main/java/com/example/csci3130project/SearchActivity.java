package com.example.csci3130project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
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

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci3130project.databinding.ActivityBaseBinding;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchactivity);
        createSearchBar();


    }

    private void createSearchBar() {
        // Creating the searchview and listeview object by finding the searchview and listview from the uI.
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);

        //creating an array to store the name of items that are available (in the future maybe database title reference etc?) and adding some dummy data
        list = new ArrayList<>();

        ArrayList<Item> itemList = new ArrayList<Item>();

        Item testitem1 = new Item("Used Chair", "Trading a used chair, sweated in once", "Furniture");
        itemList.add(testitem1);
        Item testitem2 = new Item("Xbox 360 Console", "Looking to Trade my old xbox 360", "Electronics");
        itemList.add(testitem2);
        Item testitem3 = new Item("New Kitchenware", "Trading some new kitchenware I got for christmas that I'm not using.", "Kitchenware");
        itemList.add(testitem3);
        Item testitem4 = new Item("Used Chair", "Selling a used chair, sweated in once", "Furniture");
        Item testitem5 = new Item("Used Chair", "Selling a used chair, sweated in once", "Furniture");
        /*list.add("Used Office Chair for trade");
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
        list.add("Test 6");*/

        for(int i = 0; i < itemList.toArray().length ; i++){
            String item = "Item Name: " + itemList.get(i).getName() + "\n" + "Item Description: " + itemList.get(i).getDescription() + "\n" + "Item Category: " + itemList.get(i).getCategory();
            list.add(item);
        }

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
                    Toast.makeText(SearchActivity.this, "No Match found", Toast.LENGTH_SHORT).show();
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
