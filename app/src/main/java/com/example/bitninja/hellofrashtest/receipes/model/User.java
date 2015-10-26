package com.example.bitninja.hellofrashtest.receipes.model;

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

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The latlng
     */
    public String getLatlng() {
        return latlng;
    }

    /**
     *
     * @param latlng
     * The latlng
     */
    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

}