package com.example.bitninja.hellofresh.retrofit.factory;

import android.content.Context;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.retrofit.logging.HttpLoggingInterceptor;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * RetrofitFactory.
 */
public class RetrofitFactory {

    private static RetrofitFactory _instance;
    private  final static OkHttpClient httpClient = new OkHttpClient();
    private String url = "";

    private RetrofitFactory(final Context context) {
        url = context.getString(R.string.base_url);
    }

    /**
     * Creates a new Retrofit instance, if needed.
     * @param context context
     */
    public static RetrofitFactory getInstance(final Context context) {
        if (_instance == null)
            _instance = new RetrofitFactory(context);
        return _instance;
    }

    /**
     * returns a pre build Retrofit instance
     * @return Retrofit
     */
    public Retrofit build() {

        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);

        return new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * sets the BaseUrl for api requests
     * @param url url
     */
    public void setBaseUrl(final String url) {
        this.url = url;
    }
}
