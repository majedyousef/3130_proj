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
    private ArrayList<String> comments;
    private ArrayList<Double> ratings;
    private String authorID;

    public Reputation(String author) {
        comments = new ArrayList<String>();
        ratings = new ArrayList<Double>();
        authorID = author;
    }

    public String getAuthor() {
        return authorID;
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
        calculateRating();
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
     * A method for retrieving a single comment
     * @return a String containing a written comment
     * @param commentNum - the index of the comment to get
     */
    public String getComment(int commentNum) {
        return comments.get(commentNum);
    }

    /**
     * A method for adding a comment
     * @param comment - a String containing the comment
     */
    public void addComment(String comment) {
        comments.add(comment);
    }


    /**
     * A method for retrieving the total number of reviews
     * @return an integer containing the total review number
     */
    public int getReviewCount() {
        return ratingCount;
    }
}
