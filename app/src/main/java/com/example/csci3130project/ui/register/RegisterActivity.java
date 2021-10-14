package com.example.csci3130project.ui.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csci3130project.MainActivity;
import com.example.csci3130project.R;
import com.example.csci3130project.ui.register.RegFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private EditText fname, lname, editEmail, password, password2;
    private Button regBtn;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        fname = findViewById(R.id.editRegFname);
        lname = findViewById(R.id.editRegLName);
        regBtn = findViewById(R.id.loginBtn);
        editEmail = findViewById(R.id.editRegEmail);
        password = findViewById(R.id.editRegPass);
        password2 = findViewById(R.id.editRegPassConfirm);
        firebaseAuth = FirebaseAuth.getInstance();


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String pass2 = password2.getText().toString().trim();
                String firstName = fname.getText().toString().trim();
                String lastName = lname.getText().toString().trim();

                if(pass.equals(pass2)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener
                    (RegisterActivity.this, (OnCompleteListener<AuthResult>) task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = firebaseAuth.getCurrentUser();
			    Intent intent = new Intent(getApplicationContext();
			    startActivity(intent, MainActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}