package com.example.bitninja.hellofresh.util.factory;

import android.test.ApplicationTestCase;

import com.example.bitninja.hellofresh.RestServiceTestHelper;
import com.example.bitninja.hellofresh.base.BaseApplication;
import com.example.bitninja.hellofresh.login.model.User;

/**
 * Created by Bitninja.
 */
public class GsonFactoryTest extends ApplicationTestCase<BaseApplication> {

    public GsonFactoryTest() {
        super(BaseApplication.class);
    }

    public void testGetInstance() throws Exception {
        assert GsonFactory.getInstance() != null;
    }

    public void testGetGson() throws Exception {
        assert GsonFactory.getInstance().getGson() != null;
    }

    public void testGsonDeserializeUser() throws Exception {

        final String fileName = "200_ok_response.json";
        final String json = RestServiceTestHelper.getStringFromFile(getContext(), fileName);
        assert  json != null;
        final User user = GsonFactory.getInstance().getGson().fromJson(json, User.class);
        assertEquals(user.getEmail(), "piggy@hellofresh.hf");
    }
}