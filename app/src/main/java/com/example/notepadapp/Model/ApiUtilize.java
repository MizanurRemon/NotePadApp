package com.example.notepadapp.Model;

public class ApiUtilize {

    private ApiUtilize() {
    }

    public static final String BASE_URL = "http://3.129.13.191:8082/";

    public static Login_api loginApi(){
        return RetroClient.getClient(BASE_URL).create(Login_api.class);
    }
}
