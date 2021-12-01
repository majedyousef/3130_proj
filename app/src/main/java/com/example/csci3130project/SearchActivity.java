package com.example.csci3130project;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        list = new ArrayList<>();
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference db = firebase.getReference();
        db.child("Items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot data) {
                if (data.exists()){
                    // clear the current array
                    list.clear();
                    for (DataSnapshot d:data.getChildren()){
                        String itemName = d.child("name").getValue(String.class);
                        list.add(itemName);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Creating the searchview and listeview object by finding the searchview and listview from the uI.
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.list);

        //Creating a adapter for the listview and a on query text listener that will listen to the changes in the text view
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        createSearchBar();


    }

    private void createSearchBar() {






        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //This method is performed when the user clicks the enter button and "submits" the text. this can be modified to do other things
            @Override
            public boolean onQueryTextSubmit(String query) {

//                if (list.contains(query)) {
//                    adapter.getFilter().filter(query);
//                } else {
//                    Toast.makeText(SearchActivity.this, "No Match found", Toast.LENGTH_SHORT).show();
//                }

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
