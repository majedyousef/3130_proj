package com.example.csci3130project.ui.profile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csci3130project.DatabaseUser;
import com.example.csci3130project.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.*;

public class ProfileActivity extends AppCompatActivity {
    private Button changePassword,transactionHistory,settings,logoutProfile;
    private TextView profileEmail,profileUserName,profileFullName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        profileEmail = findViewById(R.id.EmailText);
        profileUserName = findViewById(R.id.UserNameText);
        profileFullName = findViewById(R.id.FullNameText);
        changePassword = findViewById(R.id.changePassBtn);
        transactionHistory = findViewById(R.id.transactionHistoryButton);
        logoutProfile = findViewById((R.id.logOutButtonProfile));
        settings = findViewById(R.id.logOutButtonProfile);
    }
}


