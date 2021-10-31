package com.example.csci3130project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csci3130project.ui.profile.ProfileFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangePassword extends AppCompatActivity {
    EditText emailText,oldPassText,newPassText;
    Button resetPasswordButton;
    TextView display;
    DatabaseReference ref;

    String retrievedPassword;
    String retrievedUserID;
    String retrievedEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        emailText = findViewById(R.id.editTextEmailAddress);
        oldPassText = findViewById(R.id.oldPasswordText);
        newPassText = findViewById(R.id.newPasswordText);
        resetPasswordButton = findViewById(R.id.resetPassButton);
        display = findViewById(R.id.displayTextView);

        //Getting information from previous profile page using intent
        Intent intent = getIntent();
        retrievedPassword = intent.getStringExtra("passwordKey");
        retrievedUserID = intent.getStringExtra("userIdKey");
        retrievedEmail = intent.getStringExtra("emailKey");

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailText.getText().toString().trim();
                String oldPass = oldPassText.getText().toString().trim();
                String newPass = newPassText.getText().toString().trim();

                /*
                * Conditions that evaluate if the information entered is correct or not
                * If the conditions are all correct, then the password is updated
                * */

                if (email.isEmpty()){
                    emailText.setError("Email is Empty!");
                    emailText.requestFocus();
                    display.setText("Email is Invalid!");
                    return;
                }
                if ((!Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                    emailText.setError("Email is Invalid!");
                    emailText.requestFocus();
                    display.setText("Email is Invalid!");
                    return;
                }
                if (!email.equals(retrievedEmail)){
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
                if (!oldPass.equals(retrievedPassword)){
                    oldPassText.setError("Old Password is Invalid!");
                    oldPassText.requestFocus();
                    display.setText("Old Password is Invalid!");
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
                    //Creating a database reference using the user ID
                    ref = FirebaseDatabase.getInstance().getReference("User").child(retrievedUserID);
                    ref.child("password").setValue(newPass);
                    Toast.makeText(ChangePassword.this, "Password has been updated!", Toast.LENGTH_SHORT).show();
                    //After the password update, the page closes
                    finish();
                }
            }
        });
    }
}