package com.example.bitninja.hellofresh.login.model;

import com.google.gson.annotations.SerializedName;

/**
 * User.
 */
public class User {

    @SerializedName("email")
    private String email;
    @SerializedName("latLng")
    private String latLng;
    @SerializedName("name")
    private String name;

    public String getEmail() {
        return email;
    }

    public String getLatLng() {
        return latLng;
    }

    public String getName() {
        return name;
    }
}