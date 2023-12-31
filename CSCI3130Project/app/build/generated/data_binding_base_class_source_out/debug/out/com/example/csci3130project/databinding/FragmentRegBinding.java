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

public final class FragmentRegBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText editRegEmail;

  @NonNull
  public final EditText editRegFname;

  @NonNull
  public final EditText editRegLName;

  @NonNull
  public final EditText editRegPass;

  @NonNull
  public final EditText editRegPassConfirm;

  @NonNull
  public final Button regBtn;

  @NonNull
  public final TextView regEmail;

  @NonNull
  public final TextView regFname;

  @NonNull
  public final TextView regLname;

  @NonNull
  public final TextView regPass;

  @NonNull
  public final TextView regPassConfirm;

  @NonNull
  public final TextView textReg;

  private FragmentRegBinding(@NonNull ConstraintLayout rootView, @NonNull EditText editRegEmail,
      @NonNull EditText editRegFname, @NonNull EditText editRegLName, @NonNull EditText editRegPass,
      @NonNull EditText editRegPassConfirm, @NonNull Button regBtn, @NonNull TextView regEmail,
      @NonNull TextView regFname, @NonNull TextView regLname, @NonNull TextView regPass,
      @NonNull TextView regPassConfirm, @NonNull TextView textReg) {
    this.rootView = rootView;
    this.editRegEmail = editRegEmail;
    this.editRegFname = editRegFname;
    this.editRegLName = editRegLName;
    this.editRegPass = editRegPass;
    this.editRegPassConfirm = editRegPassConfirm;
    this.regBtn = regBtn;
    this.regEmail = regEmail;
    this.regFname = regFname;
    this.regLname = regLname;
    this.regPass = regPass;
    this.regPassConfirm = regPassConfirm;
    this.textReg = textReg;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_reg, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editRegEmail;
      EditText editRegEmail = ViewBindings.findChildViewById(rootView, id);
      if (editRegEmail == null) {
        break missingId;
      }

      id = R.id.editRegFname;
      EditText editRegFname = ViewBindings.findChildViewById(rootView, id);
      if (editRegFname == null) {
        break missingId;
      }

      id = R.id.editRegLName;
      EditText editRegLName = ViewBindings.findChildViewById(rootView, id);
      if (editRegLName == null) {
        break missingId;
      }

      id = R.id.editRegPass;
      EditText editRegPass = ViewBindings.findChildViewById(rootView, id);
      if (editRegPass == null) {
        break missingId;
      }

      id = R.id.editRegPassConfirm;
      EditText editRegPassConfirm = ViewBindings.findChildViewById(rootView, id);
      if (editRegPassConfirm == null) {
        break missingId;
      }

      id = R.id.regBtn;
      Button regBtn = ViewBindings.findChildViewById(rootView, id);
      if (regBtn == null) {
        break missingId;
      }

      id = R.id.regEmail;
      TextView regEmail = ViewBindings.findChildViewById(rootView, id);
      if (regEmail == null) {
        break missingId;
      }

      id = R.id.regFname;
      TextView regFname = ViewBindings.findChildViewById(rootView, id);
      if (regFname == null) {
        break missingId;
      }

      id = R.id.regLname;
      TextView regLname = ViewBindings.findChildViewById(rootView, id);
      if (regLname == null) {
        break missingId;
      }

      id = R.id.regPass;
      TextView regPass = ViewBindings.findChildViewById(rootView, id);
      if (regPass == null) {
        break missingId;
      }

      id = R.id.regPassConfirm;
      TextView regPassConfirm = ViewBindings.findChildViewById(rootView, id);
      if (regPassConfirm == null) {
        break missingId;
      }

      id = R.id.text_reg;
      TextView textReg = ViewBindings.findChildViewById(rootView, id);
      if (textReg == null) {
        break missingId;
      }

      return new FragmentRegBinding((ConstraintLayout) rootView, editRegEmail, editRegFname,
          editRegLName, editRegPass, editRegPassConfirm, regBtn, regEmail, regFname, regLname,
          regPass, regPassConfirm, textReg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
