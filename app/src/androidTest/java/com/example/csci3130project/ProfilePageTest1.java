package com.example.csci3130project;

import android.content.Context;

//import androidx.test.espresso.intent.Intents;
//import androidx.test.espresso.intent.rule.IntentsTestRule;
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
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import com.example.csci3130project.ui.profile.ProfileFragment;

import kotlin.jvm.JvmField;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ProfilePageTest1 {

    @Rule
    public ActivityScenarioRule myRule = new ActivityScenarioRule(ProfileFragment.class);
    public IntentsTestRule myIntentRule = new IntentsTestRule(ProfileFragment.class);

    @BeforeClass
    public static void setup() {
        Intents.init();
    }

    @Test
    public void checkIfProfilePageIsVisible() {
        onView(withId(R.id.EmailText)).check(matches(withText("Email")));
        onView(withId(R.id.FullNameText)).check(matches(withText("Full Name")));
        onView(withId(R.id.UserNameText)).check(matches(withText("User Name")));
    }

    @AfterClass
    public static void tearDown() {
        System.gc();
    }
}
