package com.example.bitninja.hellofrashtest.base;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by Bitninja on 21.08.2015.
 */
public abstract class BasePresenter<T> {

    private WeakReference<T> viewRef;

    public void bindView(T view) {
        viewRef = new WeakReference<T>(view);
    }

    @Nullable
    protected T getView() {
        return viewRef == null ? null : viewRef.get();
    }
}
