package com.example.csci3130project.ui.profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.csci3130project.ChangePassword;
import com.example.csci3130project.Logout;
import com.example.csci3130project.MainActivity;
import com.example.csci3130project.R;
import com.example.csci3130project.databinding.FragmentProfileBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * This class will be used for showing the user's profile
 *
 * @author Group 6, CSCI3130 F21
 */

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

    //initializing buttons and text views for the profile page
    TextView profileEmail,profileFullName,profileUserName;
    Button changePassword,transactionHistory,settings,logOutButton;
    String finalEmailHolder = "";
    String passwordOfUser = "";
    String userIdOfUser = "";
    String emailOfUser = "";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getParentFragmentManager().setFragmentResultListener("emailKey",this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                finalEmailHolder = result.getString("email");
            }
        });

        //Getting data from realtime database to display on screen of profile
        FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();
        DatabaseReference userNode = databaseInstance.getReference("User");

        //A reference to the user node is created and email,password values are retrieved.
        //Those values are then stored in the appropriate lists
        userNode.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               String emailFromDb;
               String passFromDb;
               String userNameFromDb;
               String firstNameFromDb;
               String lastNameFromDb;
               Integer userIdFromDb;
               ArrayList<String > passwordList = new ArrayList<String>();
               ArrayList<String> emailList = new ArrayList<String>();
               ArrayList<String> userNameList = new ArrayList<String>();
               ArrayList<String> firstNameList = new ArrayList<String>();
               ArrayList<String> lastNameList = new ArrayList<String>();
               ArrayList<Integer> userIdList = new ArrayList<Integer>();
               for(DataSnapshot adSnapshot: snapshot.getChildren()){
                   emailFromDb = adSnapshot.child("email").getValue(String.class);
                   passFromDb = adSnapshot.child("password").getValue(String.class);
                   userNameFromDb = adSnapshot.child("username").getValue(String.class);
                   firstNameFromDb = adSnapshot.child("firstName").getValue(String.class);
                   lastNameFromDb = adSnapshot.child("lastName").getValue(String.class);
                   userIdFromDb = adSnapshot.child("userID").getValue(Integer.class);
                   passwordList.add(passFromDb);
                   emailList.add(emailFromDb);
                   userNameList.add(userNameFromDb);
                   firstNameList.add(firstNameFromDb);
                   lastNameList.add(lastNameFromDb);
                   userIdList.add(userIdFromDb);
               }
               int indexOfUser = 0;
               for (int i = 0; i < emailList.size(); i++){
                   if (emailList.get(i).equals(finalEmailHolder)){
                       indexOfUser = i;
                   }
               }
               //Updating users profile detail
               updateProfileEmail(emailList.get(indexOfUser));
               updateProfileUserName(userNameList.get(indexOfUser));
               updateProfileFullName(firstNameList.get(indexOfUser),lastNameList.get(indexOfUser));

               //Storing the users information to transfer to other pages
               passwordOfUser = passwordList.get(indexOfUser);
               userIdOfUser = String.valueOf(userIdList.get(indexOfUser));
               emailOfUser = emailList.get(indexOfUser);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
        });

        profileEmail = root.findViewById(R.id.EmailText);
        profileFullName = root.findViewById(R.id.FullNameText);
        profileUserName = root.findViewById(R.id.UserNameText);

        //Users can log out of their account from the profile page
        logOutButton = root.findViewById(R.id.logOutButtonProfile);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Logout.class));
            }
        });

        //Users can change passwords from their profile page
        changePassword = root.findViewById(R.id.changePassBtn);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ChangePassword.class);
                intent.putExtra("passwordKey",passwordOfUser);
                intent.putExtra("userIdKey",userIdOfUser);
                intent.putExtra("emailKey",emailOfUser);
                startActivity(intent);
            }
        });
        transactionHistory = root.findViewById(R.id.transactionHistoryButton);
        transactionHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        settings = root.findViewById(R.id.settingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return root;

    }

    public String getProfileEmail() {
        return profileEmail.getText().toString().trim();
    }

    public String getProfileFullName() {
        return profileFullName.getText().toString().trim();
    }

    public String getProfileUserName() {
        return profileUserName.getText().toString().trim();
    }

    public void updateProfileEmail(String email){
        profileEmail.setText(email);
    }

    public void updateProfileFullName(String first, String second){
        profileFullName.setText(first +" "+second);
    }

    public void updateProfileUserName(String userName){
        profileUserName.setText(userName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}