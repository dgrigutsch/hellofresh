package com.example.bitninja.hellofresh.util.factory.customGsonType;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * ContentDeserializer deserialize the "contents" Node insides the Json Response.
 * It will also deserialize the Json Node by the Name from the Type
 */
public class ContentDeserializer<T> implements JsonDeserializer<T> {

    @Override
    public T deserialize(final JsonElement je, final Type type, final JsonDeserializationContext jdc) throws JsonParseException {
        // Get the "content" element from the parsed JSON
        JsonElement content = je;
        if(je.isJsonObject() && je.getAsJsonObject().has("contents")) {
            content = je.getAsJsonObject().get("contents");
            final int lastIndex = type.toString().lastIndexOf('.');
            final String name = type.toString().substring(lastIndex + 1).toLowerCase();
            if(content.isJsonObject() && content.getAsJsonObject().has(name)){
                content = content.getAsJsonObject().get(name);
            }
        }
        return new Gson().fromJson(content, type);

    }

}
