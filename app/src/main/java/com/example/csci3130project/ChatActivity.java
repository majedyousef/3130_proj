package com.example.csci3130project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChatActivity extends AppCompatActivity {
    EditText messageBox;
    Button sendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messageBox =(EditText) findViewById(R.id.chatMessage);
        sendBtn = findViewById(R.id.chatSendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempMessage = messageBox.getText().toString().trim();
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase firebase = FirebaseDatabase.getInstance();
                DatabaseReference uidRef = firebase.getReference().child("Users").child(userId);
                System.out.println(uidRef);
                if(isEmptyMsg(tempMessage)){
                    Toast.makeText(getApplicationContext(),"Message field empty",Toast.LENGTH_LONG).show();
                    return;
                }

                uidRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String usernameFromDb = snapshot.child("username").getValue(String.class);
                        Intent recipientIdIntent = getIntent();
                        String recipientId = recipientIdIntent.getStringExtra("userId");
                        Chat chat = new Chat(tempMessage,userId,usernameFromDb,recipientId);
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = database.getReference(Chat.class.getSimpleName());
                        databaseReference.push().setValue(chat).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Chat uploaded",Toast.LENGTH_LONG).show();
                                    //clearing the text box here
                                    messageBox.setText("");


                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Error not uploaded",Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage()+" "+ error.getDetails(),Toast.LENGTH_LONG).show();

                    }
                });



            }
        });
    }
    public boolean isEmptyMsg(String msg){
        return msg.isEmpty();
    }
    public boolean noRecipient(String recipient){
        return recipient.isEmpty();
    }


}