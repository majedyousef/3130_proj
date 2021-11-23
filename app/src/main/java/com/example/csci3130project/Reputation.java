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
    ArrayList<Double> ratings;

    public Reputation() {
        reviews = new ArrayList<String>();
        ratings = new ArrayList<Double>();
    }

    /**
     * A method for retrieving a single numerical rating
     * @return an double containng a numerical rating
     * @param ratingNum - the index of the rating to get
     */
    public double getRating(int ratingNum){
        return ratings.get(ratingNum);
    }

    /**
     * A method for getting the total numerical score
     * @return a double containing the score
     */
    public double getTotalScore() {
        return rating;
    }

    /**
     * A method for updating the user's overall numerical rating
     * @return rating - a double to update the rating with
     */
    public void calculateRating() {
        double sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        this.rating = sum / ratingCount;
    }

    /**
     * A method for adding a rating
     * @param rating - a double containing the rating
     */
    public void addRating(double rating) {
        ratingCount++;
        ratings.add(rating);
    }

    /**
     * A method for retrieving a single review
     * @return a String containing a written review
     * @param reviewNum - the index of the review to get
     */
    public String getReview(int reviewNum) {
        return reviews.get(reviewNum);
    }

    /**
     * A method for adding a review
     * @param review - a String containing the review
     */
    public void addReview(String review) {
        reviews.add(review);
    }

    /**
     * A method for retrieving the total number of reviews
     * @return an integer containing the total review number
     */
    public int getReviewCount() {
        return ratingCount;
    }
}
