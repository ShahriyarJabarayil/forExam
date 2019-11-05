package com.test.forexam.Model;

import com.google.gson.annotations.SerializedName;

public class Accounts {

    private String id_user;
    private String name;
    private String email;
    private String password;
    private String status;


    // Getter Methods
    @SerializedName("id_user")
    public String getId_user() {
        return id_user;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("email")
    public String getEmail() {
        return email;
    }

    @SerializedName("password")
    public String getPassword() {
        return password;
    }

    @SerializedName("status")
    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}