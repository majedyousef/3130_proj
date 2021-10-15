package com.example.csci3130project.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.csci3130project.databinding.FragmentRegBinding;

public class RegFragment extends Fragment {

    private RegViewModel regViewModel;
private FragmentRegBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        regViewModel =
                new ViewModelProvider(this).get(RegViewModel.class);

    binding = FragmentRegBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

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