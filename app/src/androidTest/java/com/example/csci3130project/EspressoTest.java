package com.example.csci3130project;


import android.content.Context;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

public class EspressoTest {

    @Rule
    public ActivityScenarioRule<BaseActivity> myRule = new ActivityScenarioRule<>(BaseActivity.class);
    public IntentsTestRule<BaseActivity> myIntentRule = new IntentsTestRule<>(BaseActivity.class);


    @BeforeClass
    public static void setup() {
        Intents.init();
    }

    @Test
    public void checkIfReturnedToLogin() {
        onView(withId(R.id.loginBtn)).perform(click());
        intended(hasComponent(Logout.class.getName()));
        onView(withId(R.id.logoutButton)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());
        intended(hasComponent(BaseActivity.class.getName()));
    }

    @Test
    public void checkIfLogoutCancelled() {
        onView(withId(R.id.loginBtn)).perform(click());
        intended(hasComponent(Logout.class.getName()));
        onView(withId(R.id.logoutButton)).perform(click());
        onView(withId(android.R.id.button2)).perform(click());
        intended(hasComponent(Logout.class.getName()));
    }



    //Test for checking if the search bar is storing the correct keyword (Same as what the user entered)
    @Test
    public void checkSearchKeyword() {
        onView(withId(R.id.loginBtn)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
        onView(withId(R.id.searchView)).perform(click());
        String searchKeyword = "Furniture";
        onView(withId(R.id.searchView)).perform(typeText(searchKeyword));
        onView(withId(R.id.searchView)).perform(pressKey(KeyEvent.KEYCODE_ENTER));
        intended(hasComponent(MainActivity.class.getName()));

        //Add logic to verify the text fields compared to the keyword to see if valid.
        
    }

}
