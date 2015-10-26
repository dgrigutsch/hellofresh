package com.example.bitninja.hellofrashtest.ui.adapter.holder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class BindingHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public BindingHolder(View rowView) {
        super(rowView);
        binding = DataBindingUtil.bind(rowView);
    }
    public ViewDataBinding getBinding() {
        return binding;
    }
}
