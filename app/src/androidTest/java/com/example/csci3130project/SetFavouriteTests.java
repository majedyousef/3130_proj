package com.example.csci3130project;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.assertEquals;

import android.app.Activity;
import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class SetFavouriteTests {

    @Rule
    public ActivityScenarioRule<SetFavourites> myRule = new ActivityScenarioRule<>(SetFavourites.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.csci3130project", appContext.getPackageName());
    }

    @Test
    public void checkIfFavouritesConfirmed() {
        onView(withId(R.id.category1)).perform(click());
        onView(withId(R.id.confirmButton)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText("Favourites have been saved.")));
    }

}
