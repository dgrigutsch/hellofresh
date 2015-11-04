package com.example.bitninja.hellofreshtest.recipes.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.bitninja.hellofreshtest.R;
import com.example.bitninja.hellofreshtest.base.BaseFragment;
import com.example.bitninja.hellofreshtest.databinding.FragmentRecipesDetailsBinding;
import com.example.bitninja.hellofreshtest.recipes.model.RecipesModel;
import com.example.bitninja.hellofreshtest.recipes.presenter.RecipesPresenter;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecipesDetailFragment extends BaseFragment<RecipesPresenter> {

    public static final String ARG_ITEM_POSITION = "itemPosition";

    public RecipesDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentRecipesDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes_details, container, false);
        View v = binding.getRoot();
        if (getArguments().containsKey(ARG_ITEM_POSITION)) {
            RecipesModel model = getPresenter().getModelByPosition(getArguments().getInt(ARG_ITEM_POSITION));
            binding.setRecipeModel(model);
        }
        RatingBar rb = (RatingBar) v.findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                // TODO rating action
                Snackbar.make(ratingBar, "Rating: " + String.valueOf(rating), Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO favorite action
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        return v;
    }
}
