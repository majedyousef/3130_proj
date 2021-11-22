package com.example.csci3130project;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReputationTests {

    Reputation reputation = new Reputation();

    @Test
    public void getRating() {
        reputation.addRating(4.5);
        assertEquals(4.5, reputation.getRating(), 0.01);
    }

    @Test
    public void addRating() {
        reputation.addRating(4.5);
        reputation.addRating(3.6);
        assertEquals(4.05, reputation.getRating(), 0.01);
    }
}
