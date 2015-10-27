package com.example.bitninja.hellofrashtest.receipes.adapter;

import android.support.annotation.Nullable;

import com.example.bitninja.hellofrashtest.ui.adapter.BindingRecyclerViewAdapter;
import com.example.bitninja.hellofrashtest.ui.binder.ItemBinder;

import java.util.Collection;

/**
 * Created by Bitninja on 27.10.2015.
 */
public class ReceipeAdapter extends BindingRecyclerViewAdapter {

    public ReceipeAdapter(ItemBinder itemBinder, @Nullable Collection items) {
        super(itemBinder, items);
    }
}
