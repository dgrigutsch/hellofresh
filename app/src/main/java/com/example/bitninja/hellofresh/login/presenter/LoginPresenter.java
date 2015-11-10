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

    public LoginPresenter(final LoginActivity activity) {
        bindView(activity);
    }

    /**
     * creates and performs the loginRequest to the Backend
     *
     * @param email    email
     * @param password password
     * @param listener listener
     */
    public void doLogin(final String email, final String password, final LoginListener listener) {
        final byte[] data = (email + password).getBytes(Charset.forName("UTF-8"));
        final AuthService loginService = RetrofitFactory.getInstance(getView())
                .build().create(AuthService.class);
        final Call<User> call = loginService.basicLogin(Base64.encodeToString(data, Base64.NO_WRAP));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(final Response<User> response, final Retrofit retrofit) {
                @SuppressWarnings("unused") final
                User user = response.body();
                listener.onLoginSuccess(user);
            }

            @Override
            public void onFailure(final Throwable t) {
                listener.onLoginFailed(t);
            }
        });
    }

    /**
     * interface to handle the loginEvents that are called from the Request
     */
    public interface LoginListener {
        void onLoginSuccess(User user);

        void onLoginFailed(Throwable t);
    }
}
