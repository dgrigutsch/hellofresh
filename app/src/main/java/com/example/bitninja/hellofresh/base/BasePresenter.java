package com.example.bitninja.hellofresh.base;

import java.lang.ref.WeakReference;

/**
 * Created by Bitninja.
 */
public abstract class BasePresenter<T> {

    private WeakReference<T> viewRef;

    public void bindView(T view) {
        viewRef = new WeakReference<>(view);
    }

    protected T getView() {
        if (viewRef.get() != null) {
            return viewRef.get();
        } else {
            throw new NullPointerException(viewRef.getClass().getSimpleName() + " is null");
        }
    }
}
