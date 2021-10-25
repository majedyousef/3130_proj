package com.example.csci3130project;

import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchFunctionality extends MainActivity {
    SearchView searchView;

    public void createNewSearch(SearchView searchView){
        this.searchView = (SearchView) findViewById(R.id.searchfield);
        this.searchView.setQueryHint("Search for an item!");
    }

    public CharSequence getQuery(){
        return searchView.getQuery();
    }

    public void setOnQueryTextListener(SearchView.OnQueryTextListener onQueryTextListener) {
        setOnQueryTextListener(onQueryTextListener);
    }
}
