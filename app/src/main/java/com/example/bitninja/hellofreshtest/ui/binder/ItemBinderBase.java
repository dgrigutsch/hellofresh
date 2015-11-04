package com.example.bitninja.hellofreshtest.ui.binder;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class ItemBinderBase<T> implements ItemBinder<T> {
    final int layoutId;
    private final int bindingVariable;

    public ItemBinderBase(int bindingVariable, int layoutId) {
        this.bindingVariable = bindingVariable;
        this.layoutId = layoutId;
    }

    public int getLayoutRes(T model) {
        return layoutId;
    }

    public int getBindingVariable(T model) {
        return bindingVariable;
    }
}
