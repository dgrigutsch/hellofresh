package com.example.bitninja.hellofresh.util.factory.customGsonType;

import com.example.bitninja.hellofresh.login.model.User;
import com.example.bitninja.hellofresh.util.factory.GsonFactory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bitninja on 09.11.2015.
 */
public class ContentDeserializerTest {

    @Test
    public void testDeserialize() throws Exception {
        User user = GsonFactory.getInstance().getGson().fromJson("null", User.class);
        assertNull("User is null",user);
    }
}