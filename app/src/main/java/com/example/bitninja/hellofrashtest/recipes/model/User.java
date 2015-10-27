package com.example.bitninja.hellofrashtest.recipes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class User {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("latlng")
    @Expose
    private String latlng;
    @SerializedName("name")
    @Expose
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