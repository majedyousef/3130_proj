package com.example.csci3130project;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReputationTests {

    Reputation reputation = new Reputation();

    @Test
    public void getRating() {
        assertEquals(4.5, reputation.getRating(), 0.1);
    }
}
