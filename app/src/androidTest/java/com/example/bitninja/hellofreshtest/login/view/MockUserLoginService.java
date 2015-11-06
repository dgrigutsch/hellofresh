package com.example.bitninja.hellofreshtest.login.view;

import com.example.bitninja.hellofreshtest.login.model.User;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Bitninja on 06.11.2015.
 */
public interface MockUserLoginService {
    @GET("/qod.json")
    Call<User> getLogin();
}
