package com.example.bitninja.hellofresh.util.factory.customGsonType;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Bitninja.
 */
public class ContentDeserializer<T> implements JsonDeserializer<T> {

    @Override
    public T deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        // Get the "content" element from the parsed JSON
        JsonElement content = je;
        if(je.isJsonObject() && je.getAsJsonObject().has("contents")) {
            content = je.getAsJsonObject().get("contents");
            int lastIndex = type.toString().lastIndexOf('.');
            String name = type.toString().substring(lastIndex+1).toLowerCase();
            if(content.isJsonObject() && content.getAsJsonObject().has(name)){
                content = content.getAsJsonObject().get(name);
            }
        }
        return new Gson().fromJson(content, type);

    }

}
