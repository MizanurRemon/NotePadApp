package com.example.notepadapp.Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Login_api {
    @FormUrlEncoded
    @POST("demo/login")
    Call<Login_response> loginResponse(@Field("UserName") String username, @Field("Password") String password);

}
