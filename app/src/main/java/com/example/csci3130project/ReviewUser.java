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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReviewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_user);

        RatingBar stars = (RatingBar) findViewById(R.id.userStars);
        EditText comment = (EditText) findViewById(R.id.commentText);
        Button submit = (Button) findViewById(R.id.submit);

        // Used for setting colors for the rating bar
        LayerDrawable starcolor = (LayerDrawable) stars.getProgressDrawable();
        starcolor.getDrawable(1).setColorFilter(Color.parseColor("#e3e6e9"), PorterDuff.Mode.SRC_ATOP);
        starcolor.getDrawable(0).setColorFilter(Color.parseColor("#e3e6e9"), PorterDuff.Mode.SRC_ATOP);

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
                    // Retrieve ID of review author

                    FirebaseUser author = FirebaseAuth.getInstance().getCurrentUser();
                    FirebaseDatabase firebase = FirebaseDatabase.getInstance();
                    DatabaseReference db = firebase.getReference();
                    String authorID;
                    if (author != null) {
                        authorID = db.child("Users").child(author.getUid()).getKey();
                    }

                    // test data
                    authorID = "testrep";

                    // Add this review to a user's reputation
                    Reputation rep = new Reputation(authorID);
                    rep.addRating(rating);
                    rep.addComment(commentText);

                    // Add reputation to database
                    db.child("Reputations").push().setValue(rep).addOnSuccessListener(success -> {
                        Toast.makeText(getApplicationContext(), "Review added successfully", Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener(fail -> {
                        Toast.makeText(getApplicationContext(), "Review failed.", Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
    }
}