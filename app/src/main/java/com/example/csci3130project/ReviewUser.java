package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class ReviewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_user);

        RatingBar stars = (RatingBar) findViewById(R.id.userStars);
        EditText comment = (EditText) findViewById(R.id.commentText);
        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get user rating and comment
                float rating = stars.getRating();
                String commentText = comment.getText().toString().trim();

                // If no rating is entered, prompt the user
                if (rating == 0) {
                    Toast.makeText(getApplicationContext(), "Please select a rating.", Toast.LENGTH_SHORT).show();
                } else {
                    // add review to user's reputation
                }
            }
        });
    }
}