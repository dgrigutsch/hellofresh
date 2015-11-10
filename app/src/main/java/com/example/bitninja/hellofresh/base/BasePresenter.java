package com.example.bitninja.hellofresh.base;

import java.lang.ref.WeakReference;

/**
 * Created by Bitninja.
 */
public abstract class BasePresenter<T> {

    private WeakReference<T> viewRef;

    /**
     * binds the view to the Presenter, most time its an activity
     * @param view view
     */
    public void bindView(final T view) {
        viewRef = new WeakReference<>(view);
    }

    /**
     * returns the view
     * @return T
     */
    protected T getView() {
        if (viewRef.get() != null) {
            return viewRef.get();
        } else {
            throw new NullPointerException(viewRef.getClass().getSimpleName() + " is null");
        }
    }
}
