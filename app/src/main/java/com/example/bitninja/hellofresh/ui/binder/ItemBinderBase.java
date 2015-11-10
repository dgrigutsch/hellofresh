package com.example.bitninja.hellofresh.ui.binder;

/**
 * ItemBinderBase.
 */
public class ItemBinderBase<T> implements ItemBinder<T> {
    final int layoutId;
    private final int bindingVariable;

    public ItemBinderBase(final int bindingVariable, final int layoutId) {
        this.bindingVariable = bindingVariable;
        this.layoutId = layoutId;
    }

    public int getLayoutRes(final T model) {
        return layoutId;
    }

    public int getBindingVariable(final T model) {
        return bindingVariable;
    }
}
