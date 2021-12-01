package com.example.csci3130project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_history);

        ListView listView = findViewById(R.id.chatHistoryList);
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        DatabaseReference chatRef = firebase.getReference("Chat");
        chatRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> previousRecipients = new ArrayList<String>();
                for(DataSnapshot adSnapShot: snapshot.getChildren()){
                    String tempRecipientName = adSnapShot.child("recipientName").getValue(String.class);

                    System.out.println(tempRecipientName);

                    if(!previousRecipients.contains(tempRecipientName)){
                        previousRecipients.add(tempRecipientName);
                    }

                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,previousRecipients);
                System.out.println("trying "+previousRecipients.get(0));
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}