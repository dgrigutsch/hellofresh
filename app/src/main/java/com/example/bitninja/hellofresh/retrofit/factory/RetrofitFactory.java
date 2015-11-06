package com.example.bitninja.hellofresh.retrofit.factory;

import android.content.Context;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.retrofit.logging.HttpLoggingInterceptor;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Bitninja.
 */
public class RetrofitFactory {

    private static RetrofitFactory _instance;
    private static OkHttpClient httpClient = new OkHttpClient();
    private String url = "";


    public RetrofitFactory(Context context) {
        url = context.getString(R.string.base_url);
    }

    public static RetrofitFactory getInstance(Context context) {
        if (_instance == null)
            _instance = new RetrofitFactory(context);
        return _instance;
    }

    public Retrofit build() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);

        return new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void setBaseUrl(String url) {
        this.url = url;
    }
}
