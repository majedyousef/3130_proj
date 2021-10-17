package com.example.csci3130project.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.csci3130project.DatabaseUser;
import com.example.csci3130project.R;
import com.example.csci3130project.User;
import com.example.csci3130project.databinding.FragmentRegBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegFragment extends Fragment {

    private RegViewModel regViewModel;
    private FragmentRegBinding binding;
    private Button regBtn;
    EditText fname, lname, editEmail, password, password2, username;

    //returns true if the input is empty
    public boolean isEmpty(String s){
        return (s == null || s.equals(""));
    }

    //returns true if any form input field is empty
    public boolean isNotComplete(String uname, String email, String pass, String pass2, String fname, String lname){
        boolean empty = isEmpty(uname) || isEmpty(email) || isEmpty(pass) || isEmpty(pass2) || isEmpty(fname) || isEmpty(lname);
        return empty;
    }

    //returns true uif the email has a valid format
    protected boolean isValidEmailAddress(String emailAddress) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }

    //Minimum password length is 8
    protected boolean validatePasswordLength(String password){
        return password.length()>=8;
    }

    //returns true if passwords match
    protected boolean passwordsMatch(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        regViewModel = new ViewModelProvider(this).get(RegViewModel.class);

        binding = FragmentRegBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //storing input values
        regBtn = root.findViewById(R.id.regBtn);
        fname = root.findViewById(R.id.editRegFname);
        lname = root.findViewById(R.id.editRegLName);
        editEmail = root.findViewById(R.id.editRegEmail);
        password = root.findViewById(R.id.editRegPass);
        password2 = root.findViewById(R.id.editRegPassConfirm);
        username = root.findViewById(R.id.editUserName);

        //button click event handling
        regBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String email = editEmail.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String pass2 = password2.getText().toString().trim();
                String firstName = fname.getText().toString().trim();
                String lastName = lname.getText().toString().trim();
                String uName = username.getText().toString().trim();

                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setUsername(uName);
                user.setPassword(pass);

                DatabaseUser db = new DatabaseUser();

                //validates input and updates database
                if (isNotComplete(uName, email, pass, pass2, firstName, lastName)){
                    Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_SHORT).show();
                } else if(!isValidEmailAddress(email)){
                    Toast.makeText(getActivity(), "Invalid email assress", Toast.LENGTH_SHORT).show();
                } else if(!validatePasswordLength(pass)){
                    Toast.makeText(getActivity(), "Minimum password length is 8", Toast.LENGTH_SHORT).show();
                } else if (!passwordsMatch(pass,pass2)){
                    Toast.makeText(getActivity(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    db.addUser(user).addOnSuccessListener(suc -> {
                        Toast.makeText(getActivity(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener(fal -> {
                        Toast.makeText(getActivity(), "Data Insertion failed", Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });

        final TextView textView = binding.textReg;
        regViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}