package com.example.bitninja.hellofrashtest.receipes.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import com.example.bitninja.hellofrashtest.BR;
import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.ui.binder.ItemBinder;
import com.example.bitninja.hellofrashtest.ui.binder.ItemBinderBase;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class ReceipeViewModel extends BaseObservable {

    @Bindable
    public ObservableArrayList<ReceipesModel> receipes;

    public ReceipeViewModel() {
        this.receipes = new ObservableArrayList<>();
    }

    public ItemBinder<ReceipesModel> itemViewBinder() {
        return new ItemBinderBase<>(BR.receipe, R.layout.item_receipe);
    }
}
