package com.example.csci3130project;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReputationTests {

    Reputation reputation = new Reputation();

    @Test
    public void getRating() {
        reputation.addRating(4.5);
        assertEquals(4.5, reputation.getRating(0), 0.01);
    }

    @Test
    public void calculateRating() {
        reputation.addRating(4.5);
        reputation.addRating(3.6);
        reputation.calculateRating();
        assertEquals(4.05, reputation.getTotalScore(), 0.01);
    }

    @Test
    public void addRating() {
        reputation.addRating(4.5);
        reputation.addRating(3.6);
        reputation.addRating(2.6);
        assertEquals(3.6, reputation.getRating(1), 0.01);
    }

    @Test
    public void getReview() {
        reputation.addReview("Not too bad");
        assertEquals("Not too bad", reputation.getReview(0));
    }

    @Test
    public void addReview() {
        reputation.addReview("Great transaction!");
        reputation.addReview("Thanks");
        reputation.addReview("Item as described");
        assertEquals("Item as described", reputation.getReview(2));
    }

    @Test
    public void getReviewCount() {
        reputation.addReview("Great transaction!");
        reputation.addRating(4.5);
        reputation.addReview("Thanks");
        reputation.addRating(5);
        reputation.addReview("Item as described");
        reputation.addRating(5);
        assertEquals(3, reputation.getReviewCount());
    }
}
