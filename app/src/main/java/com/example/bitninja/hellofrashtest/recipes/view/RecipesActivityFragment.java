package com.example.bitninja.hellofrashtest.recipes.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.databinding.FragmentRecipesBinding;
import com.example.bitninja.hellofrashtest.recipes.model.RecipeViewModel;
import com.example.bitninja.hellofrashtest.recipes.model.RecipesModel;
import com.example.bitninja.hellofrashtest.recipes.presenter.RecipesPresenter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecipesActivityFragment extends Fragment implements RecipesPresenter.ReceipesListener {

    private RecyclerView recyclerView;
    private RecipeViewModel recipeViewModel;
    private FragmentRecipesBinding binding;

    public RecipesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recipes, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.activity_users_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    @Override
    public void onLoadedFromFile(List<RecipesModel> model) {
        recipeViewModel = new RecipeViewModel();
        recipeViewModel.recipes.addAll(model);
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_recipes);
        binding.activityUsersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.setRecipeModel(recipeViewModel);

    }
}
