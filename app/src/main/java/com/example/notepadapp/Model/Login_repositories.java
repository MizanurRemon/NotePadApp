package com.example.notepadapp.Model;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_repositories {

    Login_api loginApi;
    MutableLiveData<com.example.notepadapp.Model.Login_response> idMessage;
    private static com.example.notepadapp.Model.Login_repositories login_repositories;

    protected void onSaveInstanceState(@NonNull Bundle outState) {

    }

    private Login_repositories() {
        // this.phone = phone;
        //this.password = password;
        loginApi = ApiUtilize.loginApi();
        // idMessage = new MutableLiveData<>();
    }

    public synchronized static com.example.notepadapp.Model.Login_repositories getInstance() {
        if (login_repositories == null) {
            return new com.example.notepadapp.Model.Login_repositories();
        }
        return login_repositories;
    }

    public @NonNull
    MutableLiveData<com.example.notepadapp.Model.Login_response> getIdMessage(@NonNull String username, @NonNull String password) {
        if (idMessage == null) {
            idMessage = new MutableLiveData<>();
        }
        Call<com.example.notepadapp.Model.Login_response> call = loginApi.loginResponse(username, password);
        call.enqueue(new Callback<com.example.notepadapp.Model.Login_response>() {
            private Call<com.example.notepadapp.Model.Login_response> call;
            private Throwable t;
            private Response<com.example.notepadapp.Model.Login_response> response;

            @Override
            public void onResponse(@NonNull Call<com.example.notepadapp.Model.Login_response> call, @NonNull Response<com.example.notepadapp.Model.Login_response> response) {
                this.response = response;

                if (response.isSuccessful()) {
                    com.example.notepadapp.Model.Login_response successResponse = response.body();
                    idMessage.postValue(successResponse);
                }
            }


            @Override
            public void onFailure(@NonNull Call<com.example.notepadapp.Model.Login_response> call, @NonNull Throwable t) {
                this.call = call;
                this.t = t;
                com.example.notepadapp.Model.Login_response failureResponse = new com.example.notepadapp.Model.Login_response();
                failureResponse.setId("-1");
                failureResponse.setMessage(t.getMessage());

                idMessage.postValue(failureResponse);

                Log.d("ERRORXYX", t.getMessage());

                //idMessage.postValue(t.getMessage());

            }

        });
        return idMessage;
    }

}
