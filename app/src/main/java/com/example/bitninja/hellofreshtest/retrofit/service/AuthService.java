package com.example.bitninja.hellofreshtest.retrofit.service;

import com.example.bitninja.hellofreshtest.login.model.User;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;

/**
 * Created by Bitninja.
 */
public interface AuthService {

    @GET("/login")
    Call<User> basicLogin(@Header("Authorization") String authorization);
}
