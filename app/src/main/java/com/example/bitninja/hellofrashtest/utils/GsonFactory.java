package com.example.bitninja.hellofrashtest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by Bitninja on 27.10.2015.
 */
public class GsonFactory {

    private static GsonFactory ourInstance = new GsonFactory();

    private GsonFactory() {
    }

    public static GsonFactory getInstance() {
        return ourInstance;
    }

    protected Gson getGson() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        return new Date(json.getAsJsonPrimitive().getAsLong());
                    }
                }).create();
        return gson;
    }
}
