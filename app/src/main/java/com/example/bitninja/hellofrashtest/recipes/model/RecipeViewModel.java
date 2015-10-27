package com.example.bitninja.hellofrashtest.recipes.model;

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
public class RecipeViewModel extends BaseObservable {

    @Bindable
    public ObservableArrayList<RecipesModel> recipes;

    public RecipeViewModel() {
        this.recipes = new ObservableArrayList<>();
    }

    public ItemBinder<RecipesModel> itemViewBinder() {
        return new ItemBinderBase<>(BR.recipe, R.layout.item_recipe);
    }
}
