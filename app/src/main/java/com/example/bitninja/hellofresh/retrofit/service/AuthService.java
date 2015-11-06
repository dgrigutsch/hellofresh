package com.example.bitninja.hellofresh.retrofit.service;

import com.example.bitninja.hellofresh.login.model.User;

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
