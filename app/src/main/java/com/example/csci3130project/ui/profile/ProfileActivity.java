package com.example.csci3130project.ui.profile;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csci3130project.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    private Button changePassword,transactionHistory,settings;
    private TextView email,userName,fullName;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        email = findViewById(R.id.EmailText);
        userName = findViewById(R.id.UserNameText);
        fullName = findViewById(R.id.FullNameText);
        changePassword = findViewById(R.id.changePassBtn);
        transactionHistory = findViewById(R.id.transactionHistoryButton);
        settings = findViewById(R.id.settingsButton);
    }
}

