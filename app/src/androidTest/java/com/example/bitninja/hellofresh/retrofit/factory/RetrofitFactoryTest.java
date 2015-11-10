package com.example.bitninja.hellofresh.retrofit.factory;

import android.test.ApplicationTestCase;

import com.example.bitninja.hellofresh.base.BaseApplication;
import com.squareup.okhttp.HttpUrl;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bitninja on.
 */
public class RetrofitFactoryTest extends ApplicationTestCase<BaseApplication> {

    private static final String HTTP_API_API = "http://api.api/";
    private RetrofitFactory factory;

    public RetrofitFactoryTest() {
        super(BaseApplication.class);
    }

    @Before
    public void setUp() throws Exception {
        factory = RetrofitFactory.getInstance(getContext());
    }

    public void testGetInstance() throws Exception {
        assert factory != null;
    }

    public void testBuild() throws Exception {
        assert factory.build() != null;
    }

    public void testSetBaseUrl() throws Exception {
        factory.setBaseUrl(HttpUrl.parse(HTTP_API_API).toString());
        assertEquals(factory.build().baseUrl().url().toString(), HTTP_API_API);
    }
}