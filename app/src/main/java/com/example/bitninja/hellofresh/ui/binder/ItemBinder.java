package com.example.bitninja.hellofresh.ui.binder;

/**
 * ItemBinder.
 */
public interface ItemBinder<T> {
    int getLayoutRes(T model);

    int getBindingVariable(T model);
}