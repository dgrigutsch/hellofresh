package com.example.bitninja.hellofrashtest.ui.binder;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.bitninja.hellofrashtest.ui.adapter.BindingRecyclerViewAdapter;

import java.util.Collection;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class RecyclerViewBindings
{
    private static final int KEY = -123;

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static <T> void setItems(RecyclerView recyclerView, Collection<T> items)
    {
        BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
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
    public static <T> void setItemViewBinder(RecyclerView recyclerView, ItemBinder<T> itemViewMapper)
    {
        Collection<T> items = (Collection<T>) recyclerView.getTag(KEY);
        recyclerView.setAdapter(new BindingRecyclerViewAdapter<>(itemViewMapper, items));
    }
}