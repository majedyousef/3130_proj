// Generated by view binder compiler. Do not edit!
package com.example.csci3130project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.csci3130project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText editLoginName;

  @NonNull
  public final EditText editLoginPass;

  @NonNull
  public final Button loginBtn;

  @NonNull
  public final TextView loginName;

  @NonNull
  public final TextView loginPass;

  @NonNull
  public final TextView textLogin;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView, @NonNull EditText editLoginName,
      @NonNull EditText editLoginPass, @NonNull Button loginBtn, @NonNull TextView loginName,
      @NonNull TextView loginPass, @NonNull TextView textLogin) {
    this.rootView = rootView;
    this.editLoginName = editLoginName;
    this.editLoginPass = editLoginPass;
    this.loginBtn = loginBtn;
    this.loginName = loginName;
    this.loginPass = loginPass;
    this.textLogin = textLogin;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editLoginName;
      EditText editLoginName = ViewBindings.findChildViewById(rootView, id);
      if (editLoginName == null) {
        break missingId;
      }

      id = R.id.editLoginPass;
      EditText editLoginPass = ViewBindings.findChildViewById(rootView, id);
      if (editLoginPass == null) {
        break missingId;
      }

      id = R.id.loginBtn;
      Button loginBtn = ViewBindings.findChildViewById(rootView, id);
      if (loginBtn == null) {
        break missingId;
      }

      id = R.id.loginName;
      TextView loginName = ViewBindings.findChildViewById(rootView, id);
      if (loginName == null) {
        break missingId;
      }

      id = R.id.loginPass;
      TextView loginPass = ViewBindings.findChildViewById(rootView, id);
      if (loginPass == null) {
        break missingId;
      }

      id = R.id.text_login;
      TextView textLogin = ViewBindings.findChildViewById(rootView, id);
      if (textLogin == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, editLoginName, editLoginPass,
          loginBtn, loginName, loginPass, textLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
