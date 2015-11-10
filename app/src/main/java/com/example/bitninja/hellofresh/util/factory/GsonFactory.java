package com.example.bitninja.hellofresh.util.factory;

import com.example.bitninja.hellofresh.login.model.User;
import com.example.bitninja.hellofresh.util.factory.customGsonType.ContentDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * GsonFactory.
 */
public class GsonFactory {

    private final static GsonFactory ourInstance = new GsonFactory();

    private GsonFactory() {
    }

    /**
     * returns the instance of the GsonFactory
     * @return GsonFactory
     */
    public static GsonFactory getInstance() {
        return ourInstance;
    }

    /**
     * returns a pre build Gson
     * @return Gson
     */
    public Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(User.class, new ContentDeserializer<User>())
                .create();
    }
}
