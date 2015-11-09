package com.example.bitninja.hellofresh.util.factory;

import com.example.bitninja.hellofresh.util.factory.customGsonType.ContentDeserializer;
import com.example.bitninja.hellofresh.login.model.User;
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
                .registerTypeAdapter(User.class,new ContentDeserializer<User>())
                .create();
    }
}
