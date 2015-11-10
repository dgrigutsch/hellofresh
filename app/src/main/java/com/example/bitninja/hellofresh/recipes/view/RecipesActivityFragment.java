package com.example.bitninja.hellofresh.recipes.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.base.BaseFragment;
import com.example.bitninja.hellofresh.databinding.FragmentRecipesBinding;
import com.example.bitninja.hellofresh.recipes.model.RecipeViewModel;
import com.example.bitninja.hellofresh.recipes.model.RecipesModel;
import com.example.bitninja.hellofresh.recipes.presenter.RecipesPresenter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecipesActivityFragment extends BaseFragment<RecipesPresenter> implements RecipesPresenter.RecipesListener {

    private RecyclerView recyclerView;
    private FragmentRecipesBinding binding;

    public RecipesActivityFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes, container, false);
        final View v = binding.getRoot();
        recyclerView = (RecyclerView) v.findViewById(R.id.activity_users_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getPresenter().bindListener(this);
        presenter.loadFileFromDisk();
        setTitle(RecipesActivityFragment.class.getSimpleName());
        return v;
    }

    @Override
    public void onJsonLoaded(final List<RecipesModel> model) {
        final RecipeViewModel recipeViewModel = new RecipeViewModel();
        recipeViewModel.recipes.addAll(model);
        binding.activityUsersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.activityUsersRecycler.setClickable(true);
        binding.setRecipeModel(recipeViewModel);
        binding.activityUsersRecycler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(final RecyclerView rv, final MotionEvent e) {

                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    final View childView = rv.findChildViewUnder(e.getX(), e.getY());
                    final int itemPosition = recyclerView.getChildAdapterPosition(childView);
                    presenter.startDetailsFragment(itemPosition);
                }
                return false;
            }

            @Override
            public void onTouchEvent(final RecyclerView rv, final MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(final boolean disallowIntercept) {
            }
        });
    }

}
