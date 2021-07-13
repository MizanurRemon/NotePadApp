package com.example.notepadapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notepadapp.Model.Login_repositories;
import com.example.notepadapp.Model.Login_response;

public class LoginViewModel extends AndroidViewModel {
    //Shop_login_repositories repositories;
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Login_response> getMessage(String username, String password)
    {
        return Login_repositories.getInstance().getIdMessage(username, password);
    }

}
