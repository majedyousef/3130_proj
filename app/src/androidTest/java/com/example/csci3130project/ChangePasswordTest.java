package com.example.csci3130project;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import android.content.Context;

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
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;

@RunWith(AndroidJUnit4.class)
public class ChangePasswordTest {

    @Rule
    public ActivityScenarioRule<ChangePassword> myRule = new ActivityScenarioRule<>(ChangePassword.class);
    public IntentsTestRule<ChangePassword> myIntentRule = new IntentsTestRule<>(ChangePassword.class);

    @BeforeClass
    public static void setup() {
        Intents.init();
    }

    @Test
    public void checkIfChangePasswordIsVisible() {
        onView(withId(R.id.editTextEmailAddress)).check(matches(withText("")));
        onView(withId(R.id.oldPasswordText)).check(matches(withText("")));
        onView(withId(R.id.newPasswordText)).check(matches(withText("")));
    }

    @Test
    public void checkIfEmailAndPasswordsAreValid() {
        onView(withId(R.id.editTextEmailAddress)).perform(typeText("jndoe123@gmail.com"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.oldPasswordText)).perform(typeText("1234567890"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.newPasswordText)).perform(typeText("lol12345678"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.resetPassButton)).perform(click());
        onView(withId(R.id.displayTextView)).check(matches(withText("")));
    }

    @Test
    public void checkIfEmailIsInvalid() {
        onView(withId(R.id.editTextEmailAddress)).perform(typeText("jndoe123gmail.com"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.oldPasswordText)).perform(typeText("12345678"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.newPasswordText)).perform(typeText("lol12345678"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.resetPassButton)).perform(click());
        onView(withId(R.id.displayTextView)).check(matches(withText("Email is Invalid!")));
    }

    @Test
    public void checkIfOldPassIsInvalid() {
        onView(withId(R.id.editTextEmailAddress)).perform(typeText("jndoe123@gmail.com"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.oldPasswordText)).perform(typeText("1234"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.newPasswordText)).perform(typeText("lol12345678"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.resetPassButton)).perform(click());
        onView(withId(R.id.displayTextView)).check(matches(withText("Old Password is invalid!")));
    }

    @Test
    public void checkIfNewPassIsInvalid() {
        onView(withId(R.id.editTextEmailAddress)).perform(typeText("jndoe123@gmail.com"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.oldPasswordText)).perform(typeText("12345678"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.newPasswordText)).perform(typeText("lo"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.resetPassButton)).perform(click());
        onView(withId(R.id.displayTextView)).check(matches(withText("New Password is invalid!")));
    }



}
