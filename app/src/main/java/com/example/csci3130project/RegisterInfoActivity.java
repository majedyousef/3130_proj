package com.example.csci3130project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_info);

        DatabaseReference repbd = FirebaseDatabase.getInstance().getReference("Reputations");
        Bundle extras = getIntent().getExtras();
        String ID = extras.getString("ID");
        Button confirmBtn = (Button) findViewById(R.id.confirmInfo);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Rep creation", "starting");
                repbd.child(ID).setValue(new Reputation(ID)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.e("Rep creation", "success");
                            Toast.makeText(getApplicationContext(), "Reputation initialized.", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                        }
                        else {
                            Log.e("Rep creation", "failure");
                            Toast.makeText(getApplicationContext(), "Reputation failed to initialize.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        /*
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.child("Reputation").push().setValue(reputation).addOnSuccessListener(success -> {
                    Toast.makeText(getApplicationContext(), "Reputation initialized.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                }).addOnFailureListener(fail -> {
                    Toast.makeText(getApplicationContext(), "Reputation failed to initialize.", Toast.LENGTH_SHORT).show();
                });
            }
        });*/
    }
}