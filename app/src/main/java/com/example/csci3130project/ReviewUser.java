package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
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
        LayerDrawable starcolor = (LayerDrawable) stars.getProgressDrawable();
        EditText comment = (EditText) findViewById(R.id.commentText);
        Button submit = (Button) findViewById(R.id.submit);

        // Dynamically change the color of the rating stars when it changes
        stars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                int number = (int) rating;

                if (number <= 1) {
                    // Low rating = red
                    starcolor.getDrawable(2).setColorFilter(Color.parseColor("#f38972"), PorterDuff.Mode.SRC_ATOP);
                } else if (number == 2) {
                    // Medium-rating score = orange
                    starcolor.getDrawable(2).setColorFilter(Color.parseColor("#fab45d"), PorterDuff.Mode.SRC_ATOP);
                } else if (number == 3) {
                    // Medium rating = yellow
                    starcolor.getDrawable(2).setColorFilter(Color.parseColor("#faf05d"), PorterDuff.Mode.SRC_ATOP);
                } else if (number == 4) {
                    // Medium-high rating = light green
                    starcolor.getDrawable(2).setColorFilter(Color.parseColor("#bbfa5d"), PorterDuff.Mode.SRC_ATOP);
                } else {
                    // Perfect rating = green
                    starcolor.getDrawable(2).setColorFilter(Color.parseColor("#72f43a"), PorterDuff.Mode.SRC_ATOP);
                }
            }
        });

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