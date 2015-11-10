package com.example.bitninja.hellofresh.util.factory.customGsonType;

import com.example.bitninja.hellofresh.login.model.User;
import com.example.bitninja.hellofresh.util.factory.GsonFactory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ContentDeserializerTest.
 */
public class ContentDeserializerTest {

    @Test
    public void testDeserialize() throws Exception {
        final User user = GsonFactory.getInstance().getGson().fromJson("null", User.class);
        assertNull("User is null",user);
    }
}