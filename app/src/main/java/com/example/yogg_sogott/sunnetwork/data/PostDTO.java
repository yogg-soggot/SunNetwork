package com.example.yogg_sogott.sunnetwork.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostDTO {

    @SerializedName("user_login")
    @Expose
    private String userLogin;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("id")
    @Expose
    private int id;




    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

