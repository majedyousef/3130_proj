package com.example.csci3130project.ui.register;

import com.example.csci3130project.DatabaseUser;
import com.example.csci3130project.MainActivity;
import com.example.csci3130project.R;
import com.example.csci3130project.ui.register.RegFragment;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.csci3130project.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText fname, lname, editEmail, password, password2;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reg);

        fname = findViewById(R.id.editRegFname);
        lname = findViewById(R.id.editRegLName);
        regBtn = findViewById(R.id.regBtn);
        editEmail = findViewById(R.id.editRegEmail);
        password = findViewById(R.id.editRegPass);
        password2 = findViewById(R.id.editRegPassConfirm);

        Toast.makeText(RegisterActivity.this, "hi",Toast.LENGTH_SHORT);

        regBtn.setOnClickListener(v -> {

            String email = editEmail.getText().toString().trim();
            String pass = password.getText().toString().trim();
            String pass2 = password2.getText().toString().trim();
            String firstName = fname.getText().toString().trim();
            String lastName = lname.getText().toString().trim();
            User user = new User(firstName, lastName, email, "user", pass);
            DatabaseUser db = new DatabaseUser();

            if (pass.equals(pass2)) {
                db.add(user).addOnSuccessListener(suc -> {
                    Toast.makeText(RegisterActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }).addOnFailureListener(fal -> {
                    Toast.makeText(RegisterActivity.this, "Data Insertion failed", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}
