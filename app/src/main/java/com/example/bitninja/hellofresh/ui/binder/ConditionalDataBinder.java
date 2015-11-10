package com.example.bitninja.hellofresh.ui.binder;

/**
 * ConditionalDataBinder.
 */
public abstract class ConditionalDataBinder<T> extends ItemBinderBase<T> {
    public ConditionalDataBinder(final int bindingVariable, final int layoutId) {
        super(bindingVariable, layoutId);
    }

    public abstract boolean canHandle(T model);

    @SuppressWarnings("unused")
    public boolean canHandle(final int layoutId) {
        return this.layoutId == layoutId;
    }
}
