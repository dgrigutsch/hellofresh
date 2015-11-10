package com.example.bitninja.hellofresh.login.view;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.retrofit.factory.RetrofitFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Bitninja.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        RetrofitFactory.getInstance(getActivity()).setBaseUrl("/");
    }

    @Test
    public void requestLogin() throws Exception {
        onView(withId(R.id.email)).perform(typeText("abc@def.de"));
        onView(withId(R.id.password)).perform(typeText("1234"));
        getActivity().attemptLogin();
    }
}