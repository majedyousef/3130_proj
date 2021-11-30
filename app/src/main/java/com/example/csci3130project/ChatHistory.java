package com.example.csci3130project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_history);

        ListView listView = findViewById(R.id.chatHistoryList);
        ArrayList<String> previousRecipients = new ArrayList<String>();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference chatRef = firebase.getReference().child("Chat");


    }
}