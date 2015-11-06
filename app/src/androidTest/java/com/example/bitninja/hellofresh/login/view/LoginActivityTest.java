package com.example.bitninja.hellofresh.login.view;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.retrofit.factory.RetrofitFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

//import com.example.bitninja.hellofreshtest.RestServiceTestHelper;
//import com.squareup.okhttp.mockwebserver.MockResponse;
//import com.squareup.okhttp.mockwebserver.MockWebServer;

/**
 * Created by Bitninja.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    //private MockWebServer server;

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        //server = new MockWebServer();
        //server.start();
        RetrofitFactory.getInstance(getActivity()).setBaseUrl("/");
    }

    @After
    public void tearDown() throws Exception {
//        server.shutdown();
    }

    @Test
    public void requestLogin() throws Exception {
        String fileName = "login_200_ok_response.json";
//        server.enqueue(new MockResponse()
//                .setResponseCode(200)
//                .setBody(RestServiceTestHelper.getStringFromFile(getActivity(), fileName)));

        onView(withId(R.id.email)).perform(typeText("abc@def.de"));
        onView(withId(R.id.password)).perform(typeText("1234"));
        getActivity().attemptLogin();
    }
}