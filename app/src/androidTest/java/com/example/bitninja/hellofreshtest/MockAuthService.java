package com.example.bitninja.hellofreshtest;

import com.example.bitninja.hellofreshtest.login.model.User;
import com.example.bitninja.hellofreshtest.retrofit.service.AuthService;

import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.Header;

/**
 * Created by Bitninja on 05.11.2015.
 */
public class MockAuthService implements AuthService {

    private final Retrofit retrofit;

    public MockAuthService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Call<User> basicLogin(@Header("Authorization") String authorization) {
        User user = new User();
        return null;
    }
}
