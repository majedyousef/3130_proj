package com.example.csci3130project.ui.login;

import android.content.Intent;
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

import com.example.csci3130project.BaseActivity;
import com.example.csci3130project.R;
import com.example.csci3130project.Session;
import com.example.csci3130project.User;
//import com.example.csci3130project.databinding.FragmentLoginBinding;
import com.example.csci3130project.databinding.FragmentLoginBinding;
import com.example.csci3130project.ui.profile.ProfileFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * This class will be used for logging registered users into the app.
 *
 * @author Group 6, CSCI3130 F21
 */

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;
    EditText mEmail,mPassword;
    TextView notRegistered;
    Button loginBtn;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mEmail = root.findViewById(R.id.loginEmail);
        mPassword = root.findViewById(R.id.loginPassword);
        loginBtn = root.findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                // Check if input fields empty
                if(isEmailEmpty(email)){
                    Toast.makeText(getActivity(),"Email field is empty",Toast.LENGTH_SHORT).show();
                    return;
                } else if (isPasswordEmpty(password)){
                    Toast.makeText(getActivity(),"Password field is empty",Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();
                DatabaseReference userNode = databaseInstance.getReference("User");

                //A reference to the user node is created and email,password values are retrieved.
                //Those values are the stored in 2 different arraylists.
                userNode.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Session session = new Session(getActivity().getApplication());
                        String emailFromDb;
                        String passFromDb;
                        String userNameFromDb;
                        ArrayList<String > passwordList = new ArrayList<String>();
                        ArrayList<String> emailList = new ArrayList<String>();
                        ArrayList<String> usernameList = new ArrayList<>();
                        for(DataSnapshot adSnapshot: snapshot.getChildren()){
                            emailFromDb = adSnapshot.child("email").getValue(String.class);
                            passFromDb = adSnapshot.child("password").getValue(String.class);
                            userNameFromDb = adSnapshot.child("username").getValue(String.class);
                            passwordList.add(passFromDb);
                            emailList.add(emailFromDb);
                            usernameList.add(userNameFromDb);
                            System.out.println(emailFromDb);
                            System.out.println(passFromDb);

                        }

                        // The email from the user is checked with the email from the db
                        // if the email exists the password is checked and the appropriate message is shown as a toast.
                        String successPass;
                        int indexOfUser = emailList.indexOf(email);

                        if(indexOfUser==-1){
                            Toast.makeText(getActivity(),"No such user found. Please check email or password",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            successPass = passwordList.get(indexOfUser);
                            if(successPass.equals(password)){
                                Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();
                                Bundle bundle = new Bundle();
                                bundle.putString("email",email);
                                getFragmentManager().setFragmentResult("emailKey",bundle);
                            }
                            else{
                                Toast.makeText(getActivity(),"Login Unsuccessful!! Please check email or password",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        System.out.println("On Called: Something went wrong!! Error: "+ error.getMessage());
                    }
                });



            }

        });


        final TextView textView = binding.textLogin;
        loginViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    /**
     * Check if the user is trying to login without entering email
     * @param email the email to check
     * @return true if empty, false if not
     */
    public boolean isEmailEmpty(String email){
        return email == null || email.equals("");
    }

    /**
     * Check if the user is trying to login without entering password
     * @param password the password to check
     * @return true if empty, false if not
     */
    public boolean isPasswordEmpty(String password){
        return password == null || password.equals("");
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}