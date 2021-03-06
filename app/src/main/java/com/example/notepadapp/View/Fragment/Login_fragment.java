package com.example.notepadapp.View.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notepadapp.Model.Login_response;
import com.example.notepadapp.R;
import com.example.notepadapp.ViewModel.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login_fragment extends Fragment {

    TextInputEditText userNameText, passwordText;
    TextInputLayout userNameError, passwordError;
    AppCompatButton signInButton;
    LoginViewModel loginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        //loginViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(LoginViewModel.class);

        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);

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
                userNameError.setError(" ");
            } else if (TextUtils.isEmpty(password)) {
                passwordError.setError(" ");
            }
        } else {
            sendData(username, password);
        }
    }

    private void sendData(String username, String password) {

        loginViewModel.getMessage(username, password).observe(getActivity(), new Observer<Login_response>() {
            @Override
            public void onChanged(Login_response login_response) {
                String id = login_response.getId();
                String message = login_response.getMessage();

                if (id.equals("-1")) {
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}