package com.example.bitninja.hellofresh.util.factory;

import android.test.ApplicationTestCase;

import com.example.bitninja.hellofresh.RestServiceTestHelper;
import com.example.bitninja.hellofresh.base.BaseApplication;
import com.example.bitninja.hellofresh.login.model.User;

import org.junit.Test;

/**
 * Created by Bitninja on 06.11.2015.
 */
public class GsonFactoryTest extends ApplicationTestCase<BaseApplication> {

    public GsonFactoryTest() {
        super(BaseApplication.class);
    }

    @Test
    public void testGetInstance() throws Exception {
        assert GsonFactory.getInstance() != null;
    }

    @Test
    public void testGetGson() throws Exception {
        assert GsonFactory.getInstance().getGson() != null;
    }

    @Test
    public void testGsonDeserializeUser() throws Exception {

        String fileName = "ok_response.json";
        String json = RestServiceTestHelper.getStringFromFile(getContext(), fileName);
        GsonFactory.getInstance().getGson().fromJson(json, User.class);
    }
}