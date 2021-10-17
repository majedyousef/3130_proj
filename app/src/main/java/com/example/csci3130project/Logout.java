package com.example.csci3130project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class will be used for the logout functionality.
 * The plan is to have methods that can be called within the main activity
 * as needed to log out a user
 *
 * @author Group 6, CSCI3130 F21
 */

public class Logout extends AppCompatActivity {

    Button logoutButton;

    public static boolean loggedout = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        logoutButton = (Button) findViewById(R.id.logoutButton);
        Intent in = getIntent();

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Building a new alert.
                AlertDialog.Builder logoutAlert = new AlertDialog.Builder(Logout.this);
                logoutAlert.setTitle("Logout Confirmation").
                setMessage("You sure that you want to logout? You will be redirected to the login page.");

                logoutAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    loggedout = true;
                    Intent i = new Intent(getApplicationContext(),
                    BaseActivity.class);
                    startActivity(i);
                    }
                });

                logoutAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    }
                });

                //Creating the alert and showing it to the user on the click.
                AlertDialog logoutalertDialogue = logoutAlert.create();
                logoutalertDialogue.show();
            }
        });

    }
}