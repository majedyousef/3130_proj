package com.example.csci3130project.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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
import com.example.csci3130project.MainActivity;
import com.example.csci3130project.R;
import com.example.csci3130project.User;
import com.example.csci3130project.databinding.FragmentRegBinding;

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

        regBtn = root.findViewById(R.id.regBtn);
        fname = root.findViewById(R.id.editRegFname);
        lname = root.findViewById(R.id.editRegLName);
        editEmail = root.findViewById(R.id.editRegEmail);
        password = root.findViewById(R.id.editRegPass);
        password2 = root.findViewById(R.id.editRegPassConfirm);
        username = root.findViewById(R.id.editUserName);

        regBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String email = editEmail.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String pass2 = password2.getText().toString().trim();
                String firstName = fname.getText().toString().trim();
                String lastName = lname.getText().toString().trim();
                String uName = username.getText().toString().trim();
                User user = new User(firstName, lastName, email, uName, pass);
                DatabaseUser db = new DatabaseUser();

                if (pass.equals(pass2)) {
                    db.add(user).addOnSuccessListener(suc -> {
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