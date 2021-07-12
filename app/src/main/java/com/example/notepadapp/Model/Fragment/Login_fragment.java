package com.example.notepadapp.Model.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notepadapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login_fragment extends Fragment {

    TextInputEditText userNameText, passwordText;
    TextInputLayout userNameError, passwordError;
    AppCompatButton signInButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        userNameText = (TextInputEditText) view.findViewById(R.id.usernameTextID);
        passwordText = (TextInputEditText) view.findViewById(R.id.passwordTextID);
        userNameError = (TextInputLayout) view.findViewById(R.id.usernameErrorID);
        passwordError = (TextInputLayout) view.findViewById(R.id.passwordErrorID);

        signInButton = (AppCompatButton) view.findViewById(R.id.signInButtonID);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();

                userNameError.setErrorEnabled(false);
                passwordError.setErrorEnabled(false);

                validation(username, password);
            }
        });
        return view;
    }

    private void validation(String username, String password) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            if (TextUtils.isEmpty(username)) {
                userNameError.setErrorEnabled(true);
            } else if (TextUtils.isEmpty(password)) {
                passwordError.setErrorEnabled(true);
            }
        } else {
            sendData(username, password);
        }
    }

    private void sendData(String username, String password) {

    }
}