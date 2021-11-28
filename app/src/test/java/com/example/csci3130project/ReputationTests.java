package com.example.csci3130project;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReputationTests {

    Reputation reputation = new Reputation("123");

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
        reputation.addComment("Not too bad");
        assertEquals("Not too bad", reputation.getComment(0));
    }

    @Test
    public void addComment() {
        reputation.addComment("Great transaction!");
        reputation.addComment("Thanks");
        reputation.addComment("Item as described");
        assertEquals("Item as described", reputation.getComment(2));
    }

    @Test
    public void getReviewCount() {
        reputation.addComment("Great transaction!");
        reputation.addRating(4.5);
        reputation.addComment("Thanks");
        reputation.addRating(5);
        reputation.addComment("Item as described");
        reputation.addRating(5);
        assertEquals(3, reputation.getReviewCount());
    }
}
