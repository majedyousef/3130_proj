package com.example.csci3130project;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import com.example.csci3130project.ui.profile.ProfileFragment;

public class ProfilePageTest2 {

    static ProfileFragment profileFragment = null;


    @BeforeClass
    public static void setup() {
        profileFragment = Mockito.mock(ProfileFragment.class);
        Mockito.when(profileFragment.getProfileEmail()).thenReturn("jndoe123@gmail.com");
        Mockito.when(profileFragment.getProfileFullName()).thenReturn("Jane Doe");
        Mockito.when(profileFragment.getProfileUserName()).thenReturn("jndoe111");
    }

    @AfterClass
    public static void tearDown() {
        System.gc();
    }

    //Checks if users name appears on the top of the screen
    @Test
    public void checkIfFullNameAppears() {

    }

    @Test
    public void testGetProfileEmail() {
        assertEquals("jndoe123@gmail.com",profileFragment.getProfileEmail());
    }

    @Test
    public void testGetProfileFullName() {
        assertEquals("Jane Doe",profileFragment.getProfileFullName());
    }

    @Test
    public void testGetProfileUserName() {
        assertEquals("jndoe111",profileFragment.getProfileUserName());
    }


}
