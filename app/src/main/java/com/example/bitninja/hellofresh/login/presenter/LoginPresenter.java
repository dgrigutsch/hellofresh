package com.example.bitninja.hellofresh.login.presenter;

import android.util.Base64;

import com.example.bitninja.hellofresh.base.BasePresenter;
import com.example.bitninja.hellofresh.login.model.User;
import com.example.bitninja.hellofresh.login.view.LoginActivity;
import com.example.bitninja.hellofresh.retrofit.factory.RetrofitFactory;
import com.example.bitninja.hellofresh.retrofit.service.AuthService;

import java.nio.charset.Charset;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Bitninja.
 */
public class LoginPresenter extends BasePresenter<LoginActivity> {

    public LoginPresenter(LoginActivity activity) {
        bindView(activity);
    }

    public void doLogin(String email, String password, final LoginListener listener) {
        byte[] data = (email + password).getBytes(Charset.forName("UTF-8"));
        final AuthService loginService = RetrofitFactory.getInstance(getView())
                .build().create(AuthService.class);
        Call<User> call = loginService.basicLogin(Base64.encodeToString(data, Base64.NO_WRAP));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                @SuppressWarnings("unused")
                User user = response.body();
                listener.onLoginSuccess(user);
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onLoginFailed(t);
            }
        });
    }

    public interface LoginListener {
        void onLoginSuccess(User user);

        void onLoginFailed(Throwable t);
    }
}
