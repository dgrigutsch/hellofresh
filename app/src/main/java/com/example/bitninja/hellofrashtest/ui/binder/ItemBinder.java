package com.example.bitninja.hellofrashtest.ui.binder;

/**
 * Created by Bitninja on 26.10.2015.
 */
public interface ItemBinder<T> {
    int getLayoutRes(T model);

    int getBindingVariable(T model);
}