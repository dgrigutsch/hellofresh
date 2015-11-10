package com.example.bitninja.hellofresh.base;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bitninja.
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

    /**
     * sets a new presenter instance.
     * @param presenter Presenter
     */
    @SuppressWarnings("unused")
    public void setPresenter(@NonNull final P presenter) {
        this.presenter = presenter;
    }

}
