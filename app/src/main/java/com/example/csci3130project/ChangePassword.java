package com.example.csci3130project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangePassword extends AppCompatActivity {
    EditText emailText,oldPassText,newPassText;
    Button resetPasswordButton;
    TextView display;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        emailText = findViewById(R.id.editTextEmailAddress);
        oldPassText = findViewById(R.id.oldPasswordText);
        newPassText = findViewById(R.id.newPasswordText);
        resetPasswordButton = findViewById(R.id.resetPassButton);
        display = findViewById(R.id.displayTextView);

        //needs to get the users ID from the profile page
        ref = FirebaseDatabase.getInstance().getReference("User").child("1");

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailText.getText().toString().trim();
                String oldPass = oldPassText.getText().toString().trim();
                String newPass = newPassText.getText().toString().trim();

                if (email.isEmpty()){
                    emailText.setError("Email is Empty!");
                    emailText.requestFocus();
                    display.setText("Email is Invalid!");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailText.setError("Email is Invalid!");
                    emailText.requestFocus();
                    display.setText("Email is Invalid!");
                    return;
                }
                if (oldPass.length() < 8){
                    oldPassText.setError("Old Password is invalid!");
                    oldPassText.requestFocus();
                    display.setText("Old Password is invalid!");
                    return;
                }
                if (newPass.length() < 8){
                    newPassText.setError("New Password is invalid!");
                    newPassText.requestFocus();
                    display.setText("New Password is invalid!");
                    return;
                }
                if ((newPass.length() >= 8) && (oldPass.length() >= 8) && (Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                    display.setText("");
                }
            }
        });
    }
}