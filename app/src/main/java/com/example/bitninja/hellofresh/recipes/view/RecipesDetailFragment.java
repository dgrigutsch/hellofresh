package com.example.bitninja.hellofresh.recipes.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.base.BaseFragment;
import com.example.bitninja.hellofresh.databinding.FragmentRecipesDetailsBinding;
import com.example.bitninja.hellofresh.recipes.model.RecipesModel;
import com.example.bitninja.hellofresh.recipes.presenter.RecipesPresenter;
import com.example.bitninja.hellofresh.util.factory.SharedPreferencesFactory;
import com.example.bitninja.hellofresh.BR;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecipesDetailFragment extends BaseFragment<RecipesPresenter> {

    public static final String ARG_ITEM_POSITION = "itemPosition";
    private RecipesModel model;

    public RecipesDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FragmentRecipesDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes_details, container, false);
        View v = binding.getRoot();
        if (getArguments().containsKey(ARG_ITEM_POSITION)) {
            model = getPresenter().getModelByPosition(getArguments().getInt(ARG_ITEM_POSITION));
            binding.setRecipeModel(model);
        }
        RatingBar rb = (RatingBar) v.findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                model.setRating((double) rating);
                presenter.saveRecipeModel(model);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.isMarked())
                    SharedPreferencesFactory.getInstance().unmarkAsFavorite(model.getId());
                else
                    SharedPreferencesFactory.getInstance().markAsFavorite(model.getId());
                binding.setVariable(BR.recipeModel, model);
            }
        });
        return v;
    }
}
