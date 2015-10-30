package com.example.bitninja.hellofreshtest.base;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bitninja on 26.10.2015.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    /**
     * The presenter for this view. Will be instantiated with {@link #getPresenter()}
     */
    protected P presenter;

    /**
     * Creates a new presenter instance, if needed.
     * //
     */
    public abstract P getPresenter();

    public void setPresenter(@NonNull P presenter) {
        this.presenter = presenter;
    }

}
