package com.example.csci3130project;

import java.util.ArrayList;

/**
 * The Reputation class is used to create Reputation objects for the application.
 * These objects store ratings and reviews for a user.
 *
 * @author Group 6, CSCI3130 F21
 */

public class Reputation {

    private double rating;
    private int ratingCount;
    ArrayList<String> reviews;

    public Reputation() {
        reviews = new ArrayList<String>();
        reviews.add("Not too bad");
    }

    /**
     * A method for retrieving the user's numerical rating
     * @return an double representing the user's rating
     */
    public double getRating(){
        return rating;
    }

    /**
     * A method for updating the user's numerical rating
     * @param rating - a double to update the rating with
     */
    public void addRating(double rating) {
        ratingCount++;
        this.rating = (this.rating + rating) / ratingCount;
    }

    /**
     * A method for retrieving a single review
     * @return a String containing a written review
     * @param reviewNum - the index of the review to get
     */
    public String getReview(int reviewNum) {
        return reviews.get(reviewNum);
    }
}
