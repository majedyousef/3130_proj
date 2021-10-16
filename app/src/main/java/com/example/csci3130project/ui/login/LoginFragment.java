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

import com.example.csci3130project.R;
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
                FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();
                DatabaseReference userNode = databaseInstance.getReference("User");

                userNode.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String emailFromDb;
                        String passFromDb;
                        ArrayList<String > passwordList = new ArrayList<String>();
                        ArrayList<String> emailList = new ArrayList<String>();
                        for(DataSnapshot adSnapshot: snapshot.getChildren()){
                            emailFromDb= adSnapshot.child("email").getValue(String.class);
                            passFromDb = adSnapshot.child("password").getValue(String.class);
                            passwordList.add(passFromDb);
                            emailList.add(emailFromDb);
                            System.out.println(emailFromDb);
                            System.out.println(passFromDb);

                        }
                        String successPass;
                        int indexOfUser = emailList.indexOf(email);
                        System.out.println("From ArrayList "+emailList.get(0));
                        System.out.println("From pass list: "+ passwordList.get(0));

                        if(indexOfUser==-1){
                            Toast.makeText(getActivity(),"No such user found. Please check email or password",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            successPass = passwordList.get(indexOfUser);
                            if(successPass.equals(password)){
                                Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}