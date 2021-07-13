package com.example.notepadapp.Model;

import com.google.gson.annotations.SerializedName;

public class Login_response {
    @SerializedName("message")
    private String message;
    @SerializedName("id")
    private String id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
