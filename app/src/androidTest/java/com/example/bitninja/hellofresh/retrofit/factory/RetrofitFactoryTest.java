package com.example.bitninja.hellofresh.retrofit.factory;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.bitninja.hellofresh.base.BaseApplication;
import com.squareup.okhttp.HttpUrl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bitninja on.
 */
public class RetrofitFactoryTest extends ApplicationTestCase<BaseApplication> {

    public static final String HTTP_API_API = "http://api.api/";
    private RetrofitFactory factory;

    public RetrofitFactoryTest() {
        super(BaseApplication.class);
    }

    @Before
    public void setUp() throws Exception {
        factory = RetrofitFactory.getInstance(getContext());
    }

    @Test
    public void testGetInstance() throws Exception {
        assert factory != null;
    }

    @Test
    public void testBuild() throws Exception {
        assert factory.build() != null;
    }

    @Test
    public void testSetBaseUrl() throws Exception {
        factory.setBaseUrl(HttpUrl.parse(HTTP_API_API).toString());
        assertEquals(factory.build().baseUrl().url().toString(), HTTP_API_API);
    }
}