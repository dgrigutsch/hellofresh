package com.example.bitninja.hellofresh.ui.binder;

/**
 * CompositeItemBinder.
 */
@SuppressWarnings("unused")
public class CompositeItemBinder<T> implements ItemBinder<T> {
    private final ConditionalDataBinder<T>[] conditionalDataBinders;

    @SafeVarargs
    public CompositeItemBinder(final ConditionalDataBinder<T>... conditionalDataBinders) {
        this.conditionalDataBinders = conditionalDataBinders;
    }

    @Override
    public int getLayoutRes(final T model) {
        for (final ConditionalDataBinder<T> dataBinder : conditionalDataBinders) {
            if (dataBinder.canHandle(model)) {
                return dataBinder.getLayoutRes(model);
            }
        }

        throw new IllegalStateException();
    }

    @Override
    public int getBindingVariable(final T model) {
        for (final ConditionalDataBinder<T> dataBinder : conditionalDataBinders) {
            if (dataBinder.canHandle(model)) {
                return dataBinder.getBindingVariable(model);
            }
        }

        throw new IllegalStateException();
    }
}