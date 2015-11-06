package com.example.bitninja.hellofreshtest.login.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class User {

    @SerializedName("email")
    private String email;
    @SerializedName("latlng")
    private String latlng;
    @SerializedName("name")
    private String name;

    public String getEmail() {
        return email;
    }

    public String getLatlng() {
        return latlng;
    }

    public String getName() {
        return name;
    }
}