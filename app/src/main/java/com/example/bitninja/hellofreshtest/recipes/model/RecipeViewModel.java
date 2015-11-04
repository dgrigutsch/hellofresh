package com.example.bitninja.hellofreshtest.recipes.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import com.example.bitninja.hellofreshtest.BR;
import com.example.bitninja.hellofreshtest.R;
import com.example.bitninja.hellofreshtest.ui.binder.ItemBinder;
import com.example.bitninja.hellofreshtest.ui.binder.ItemBinderBase;

/**
 * Created by Bitninja.
 */
public class RecipeViewModel extends BaseObservable {

    @Bindable
    public final ObservableArrayList<RecipesModel> recipes;

    public RecipeViewModel() {
        this.recipes = new ObservableArrayList<>();
    }

    public ItemBinder<RecipesModel> itemViewBinder() {
        return new ItemBinderBase<>(BR.recipe, R.layout.item_recipe);
    }
}
