package com.example.bitninja.hellofreshtest.util.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Bitninja.
 */
public class GsonFactory {

    private final static GsonFactory ourInstance = new GsonFactory();

    private GsonFactory() {
    }

    public static GsonFactory getInstance() {
        return ourInstance;
    }

    public Gson getGson() {
        return new GsonBuilder()
                .create();
    }
}
