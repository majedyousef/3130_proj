package com.example.csci3130project;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.csci3130project.BaseActivity;
import com.example.csci3130project.Logout;
import com.example.csci3130project.R;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class MapEspressoTest {

    @Rule
    public ActivityScenarioRule<BaseActivity> myRule = new ActivityScenarioRule<>(BaseActivity.class);

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void userInputScenarioTest(){
//        // input some text in the edit Text
//        Espresso.onView(withId(R.id.etTextToUpdate)).perform(typeText(text));
//        // Close the soft Keyboard
//        Espresso.closeSoftKeyboard();
//        // perform Button Click
//        Espresso.onView(withId(R.id.btn)).perform(click());
//        Espresso.onView(withId(R.id.tvChangedText)).check(matches(withText(text)));
//        // Checking the text in the textView

    }
    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void checkIfReturnedToLogin() {
        onView(withId(R.id.loginBtn)).perform(click());
        intended(hasComponent(Logout.class.getName()));
        onView(withId(R.id.logoutButton)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());
        intended(hasComponent(BaseActivity.class.getName()));
    }




}