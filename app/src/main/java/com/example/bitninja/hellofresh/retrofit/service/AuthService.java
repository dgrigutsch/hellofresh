package com.example.bitninja.hellofresh.retrofit.service;

import com.example.bitninja.hellofresh.login.model.User;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;

/**
 * AuthService.
 */
public interface AuthService {

    /**
     * Interface for Retrofit to send a Login Request to the Backend
     * @param authorization authorization key
     * @return Call<User>
     */
    @GET("/login")
    Call<User> basicLogin(@Header("Authorization") String authorization);
}
