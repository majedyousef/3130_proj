package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class SetFavourites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_favourites);

        ArrayList<String> favourites = new ArrayList<String>();

        Button confirmButton = findViewById(R.id.confirmButton);

        // Retrieve category checkboxes
        CheckBox category1 = findViewById(R.id.category1);
        CheckBox category2 = findViewById(R.id.category2);
        CheckBox category3 = findViewById(R.id.category3);
        CheckBox category4 = findViewById(R.id.category4);
        CheckBox category5 = findViewById(R.id.category5);
        TextView statusLabel = findViewById(R.id.statusLabel);

        // Confirm the user's choice of favourite categories
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Reset status message
                String emptyStatus = "";
                statusLabel.setText(emptyStatus);

                // If a category is selected, add it to the favourites collection
                if (category1.isChecked()) {
                    favourites.add(category1.getText().toString());
                }
                if (category2.isChecked()) {
                    favourites.add(category2.getText().toString());
                }
                if (category3.isChecked()) {
                    favourites.add(category3.getText().toString());
                }
                if (category4.isChecked()) {
                    favourites.add(category4.getText().toString());
                }
                if (category5.isChecked()) {
                    favourites.add(category5.getText().toString());
                }

                // Add selections to database
                DatabaseFavourites submitFaves = new DatabaseFavourites();
                submitFaves.addFaves(favourites);

                // Confirm favourite category selections
                String savedMessage = "Favourites have been saved.";
                statusLabel.setText(savedMessage);

            }
        });
    }
}