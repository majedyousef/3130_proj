package com.example.csci3130project;

import android.content.Context;

//import androidx.test.espresso.intent.Intents;
//import androidx.test.espresso.intent.rule.IntentsTestRule;
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

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
//public class ProfilePageTest1 {
//    public ActivityScenarioRule<MainActivity> myRule = new ActivityScenarioRule<>(MainActivity.class);
//
//    /*
//    @BeforeClass
//    public static void setup() {
//        Intents.init();
//    }*/
//
//    @Test
//    public void useAppContext() {
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.csci3130project", appContext.getPackageName());
//    }
//
//    @Test
//    public void checkIfProfilePageIsVisible() {
//
//    }
//
//    @Test
//    public void checkPasswordChange(){
//
//    }
//
//    //Checks if users name appears on the top of the screen
//    @Test
//    public void checkIfNameIsVisible() {
//
//    }
//
//    //Checks if bio is visible on page
//    @Test
//    public void checkIfBioIsVisible() {
//
//    }
//
//    //check if password change pop up appears on screen
//    @Test
//    public void checkIfChangePasswordAppears() {
//
//    }
//
//    @Test
//    public void checkIfPasswordisValid() {
//
//    }
//
//    @Test
//    public void checkIfPasswordisInvalid() {
//
//    }
//
//    //Checks if change profile image pops up on the current screen
//    @Test
//    public void checkIfChangeProfileImageAppears() {
//
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        System.gc();
//    }
//}
