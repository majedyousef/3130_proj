package com.example.csci3130project;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchpage);


        //Method for creating the search bar.
        createSearchBar();


    }

    private void createSearchBar() {
        // Creating the searchview and listeview object by finding the searchview and listview from the uI.
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);

        //creating an array to store the name of items that are available
        list = new ArrayList<>();

        ArrayList<Item> itemList = new ArrayList<Item>();
        Item testitem1 = new Item("Used Chair", "Trading a used chair, sweated in once", "Furniture");
        itemList.add(testitem1);
        Item testitem2 = new Item("Xbox 360 Console", "Looking to Trade my old xbox 360", "Electronics");
        itemList.add(testitem2);
        Item testitem3 = new Item("New Kitchenware", "Trading some new kitchenware I got for christmas that I'm not using.", "Kitchenware");
        itemList.add(testitem3);
        Item testitem4 = new Item("Hockey Sticks", "Got a bunch of hockey sticks I don't need.", "Sports");
        itemList.add(testitem4);
        Item testitem5 = new Item("Unwanted food/nonperishables", "I have a variety of cans of food for exchange, not looking for anything specific", "Food");
        itemList.add(testitem5);
        //This loop goes through the itemList array (contains the items from the database, right now dummy data) and adds the info to a string list (list)
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
                    Toast.makeText(Search.this, "No Match found", Toast.LENGTH_SHORT).show();
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
