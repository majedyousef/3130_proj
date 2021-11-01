package com.example.csci3130project;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class SetFavouriteTests {

    public ActivityScenarioRule<SetFavourites> myRule = new ActivityScenarioRule<>(SetFavourites.class);

    @Test
    public void checkIfFavouritesConfirmed() {
        onView(withId(R.id.confirmButton)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText("Favourites have been saved.")));
    }

}
