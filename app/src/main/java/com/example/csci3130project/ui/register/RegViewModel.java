package com.example.csci3130project.ui.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the Registration Page");
    }

    public LiveData<String> getText() {
        return mText;
    }
}