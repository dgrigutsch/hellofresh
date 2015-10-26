package com.example.bitninja.hellofrashtest.ui.binder;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class ItemBinderBase<T> implements ItemBinder<T> {
    protected final int bindingVariable;
    protected final int layoutId;

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
