package com.example.csci3130project.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.csci3130project.R;
import com.example.csci3130project.databinding.FragmentProfileBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * This class will be used for showing the user's profile
 *
 * @author Group 6, CSCI3130 F21
 */

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;
    private Button changePassword,transactionHistory,settings,logoutProfile;
    private TextView profileEmail,profileUserName,profileFullName;

    FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();
    DatabaseReference userNode = databaseInstance.getReference("User");

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        profileEmail = root.findViewById(R.id.EmailText);
        profileUserName = root.findViewById(R.id.UserNameText);
        profileFullName = root.findViewById(R.id.FullNameText);
        changePassword = root.findViewById(R.id.changePassBtn);
        transactionHistory = root.findViewById(R.id.transactionHistoryButton);
        logoutProfile = root.findViewById((R.id.logOutButtonProfile));
        settings = root.findViewById(R.id.logOutButtonProfile);

        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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

    public String getProfileFullName(){
        return profileFullName.toString();
    }

    public String getProfileEmail(){
        return profileEmail.toString();
    }

    public String getProfileUserName(){
        return profileUserName.toString();
    }

}