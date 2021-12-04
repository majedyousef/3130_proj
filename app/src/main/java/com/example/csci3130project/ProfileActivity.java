package com.example.csci3130project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference db = firebase.getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        if (user != null){
            TextView nameBox = findViewById(R.id.FullNameText);
            TextView emailBox = findViewById(R.id.EmailText);
            TextView userNameBox = findViewById(R.id.UserNameText);

            db.child("Users").child(user.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot data) {
                    String fName = data.child("firstName").getValue(String.class);
                    String lName =  data.child("lastName").getValue(String.class);
                    String fullName = fName + " " + lName;
                    String userName = data.child("username").getValue(String.class);
                    String email = data.child("email").getValue(String.class);
                    nameBox.setText(fullName);
                    emailBox.setText(email);
                    userNameBox.setText(userName);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            // Intent to the password change page
            Button changePass = (Button) findViewById(R.id.changePassBtn);
            changePass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), ChangePasswordActivity.class);
                    startActivity(i);
                }
            });

            // Intent to the password change page
            Button logout = (Button) findViewById(R.id.logOutButtonProfile);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    auth.signOut();
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                }
            });

            // Intent to transaction page
            Button transaction = (Button) findViewById(R.id.transactionHistoryButton);
            transaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), TransactionHistory.class);
                    startActivity(i);
                }
            });

            // Intent to favourite categories page
            Button favorites = (Button) findViewById(R.id.favBtn);
            favorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), SetFavourites.class);
                    startActivity(i);
                }
            });
        }
    }
}