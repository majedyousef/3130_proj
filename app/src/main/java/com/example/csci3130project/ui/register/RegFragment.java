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

/**
 * This class will be used for registering a user in the database with the UI
 *
 * @author Group 6, CSCI3130 F21
 */

public class RegFragment extends Fragment {

    private RegViewModel regViewModel;
    private FragmentRegBinding binding;
    private Button regBtn;
    EditText fname, lname, editEmail, password, password2, username;

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

                // Validate user input and inform user of errors
                if (isNotComplete(uName, email, pass, pass2, firstName, lastName)){
                    Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_SHORT).show();
                } else if(!isValidEmailAddress(email)){
                    Toast.makeText(getActivity(), "Invalid email assress", Toast.LENGTH_SHORT).show();
                } else if(!validatePasswordLength(pass)){
                    Toast.makeText(getActivity(), "Minimum password length is 8", Toast.LENGTH_SHORT).show();
                } else if (!passwordsMatch(pass,pass2)){
                    Toast.makeText(getActivity(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Otherwise, create a new user and add them to the database
                    DatabaseUser db = new DatabaseUser();
                    User newUser = createNewUser(firstName, lastName, email, uName, pass);
                    db.addUser(newUser).addOnSuccessListener(suc -> {
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

    /**
     * A method for creating a new User to register
     * @param fname The first name of the user
     * @param lname The last name of the user
     * @param email The email of the user
     * @param uname The username of the user
     * @param pass The password of the user
     * @return the new User to be added to the database
     */
    public User createNewUser(String fname, String lname, String email, String uname, String pass) {
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(email);
        user.setUsername(uname);
        user.setPassword(pass);
        return user;
    }

    /**
     * Checks if the current input string is empty
     * @param s the String the check
     * @return true if empty, false if not
     */
    public boolean isEmpty(String s){
        return (s == null || s.equals(""));
    }

    /**
     * Checks if any of the input fields are unfilled
     * @param fname The first name of the user
     * @param lname The last name of the user
     * @param email The email of the user
     * @param uname The username of the user
     * @param pass The password of the user
     * @return true if input is incomplete, false if they are all filled
     */
    public boolean isNotComplete(String uname, String email, String pass, String pass2, String fname, String lname){
        boolean empty = isEmpty(uname) || isEmpty(email) || isEmpty(pass) || isEmpty(pass2) || isEmpty(fname) || isEmpty(lname);
        return empty;
    }

    /**
     * Use regex to check that the user email is a valid email
     * @param emailAddress the email to check
     * @return true if the email is valid, false if not
     */
    public boolean isValidEmailAddress(String emailAddress) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }

    /**
     * Check that the user's password is long enough
     * @param password the proposed password
     * @return true if it's logn enough, false otherwise
     */
    public boolean validatePasswordLength(String password){
        return password.length()>=8;
    }

    /**
     * Check if the user's password confirmation matches
     * @param pass1 the first password input
     * @param pass2 the confirmation password input
     * @return true if the passwords match, false if they do not
     */
    public boolean passwordsMatch(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}