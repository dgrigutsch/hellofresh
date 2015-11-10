package com.example.bitninja.hellofresh.ui.binder;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.bitninja.hellofresh.ui.adapter.BindingRecyclerViewAdapter;

import java.util.Collection;

/**
 * RecyclerViewBindings.
 */
@SuppressWarnings("unused")
public class RecyclerViewBindings
{
    private static final int KEY = -123;

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static <T> void setItems(final RecyclerView recyclerView, final Collection<T> items)
    {
        final BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null)
        {
            adapter.setItems(items);
        }
        else
        {
            recyclerView.setTag(KEY, items);
        }
    }


    @SuppressWarnings("unchecked")
    @BindingAdapter("itemViewBinder")
    public static <T> void setItemViewBinder(final RecyclerView recyclerView, final ItemBinder<T> itemViewMapper)
    {
        final Collection<T> items = (Collection<T>) recyclerView.getTag(KEY);
        recyclerView.setAdapter(new BindingRecyclerViewAdapter<>(itemViewMapper, items));
    }
}