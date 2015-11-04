package com.example.bitninja.hellofreshtest.recipes.presenter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.example.bitninja.hellofreshtest.R;
import com.example.bitninja.hellofreshtest.base.BasePresenter;
import com.example.bitninja.hellofreshtest.recipes.model.RecipesModel;
import com.example.bitninja.hellofreshtest.recipes.view.RecipesActivity;
import com.example.bitninja.hellofreshtest.recipes.view.RecipesActivityFragment;
import com.example.bitninja.hellofreshtest.recipes.view.RecipesDetailFragment;
import com.example.bitninja.hellofreshtest.util.JSONResourceReader;
import com.example.bitninja.hellofreshtest.util.factory.SharedPreferencesFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bitninja.
 */
public class RecipesPresenter extends BasePresenter<RecipesActivity> {

    private List<RecipesModel> recipesModel;
    private RecipesListener listener;

    public RecipesPresenter(RecipesActivity activity) {
        bindView(activity);
    }

    public void bindListener(final RecipesListener listener) {
        this.listener = listener;
    }

    public void loadFileFromDisk() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                RecipesModel[] modelFromPrefs = SharedPreferencesFactory.getInstance(getView()).getModelFromPrefs();
                if (modelFromPrefs == null) {
                    JSONResourceReader reader = new JSONResourceReader(getView().getResources(), R.raw.recipes);
                    RecipesModel[] response = reader.constructUsingGson(RecipesModel[].class);
                    recipesModel = Arrays.asList(response);
                    SharedPreferencesFactory.getInstance(getView()).writeRecipeModelToPrefs(recipesModel);
                } else {
                    recipesModel = Arrays.asList(modelFromPrefs);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                getView().hidePrograssBar();
                listener.onLoadedFromFile(recipesModel);
            }
        }.execute();
    }

    public void startDetailsFragment(int itemPosition) {

        Bundle bundle = new Bundle();
        bundle.putInt(RecipesDetailFragment.ARG_ITEM_POSITION, itemPosition);

        RecipesDetailFragment fragment = new RecipesDetailFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getView().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, fragment.getStringTag());
        transaction.addToBackStack(null);
        transaction.commit();
        fragment.setTitle(fragment.getStringTag());
    }

    public void startRecipeFragment() {

        RecipesActivityFragment fragment = new RecipesActivityFragment();
        FragmentTransaction transaction = getView().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, fragment.getStringTag());
        transaction.addToBackStack(null);
        transaction.commit();
        fragment.setTitle(fragment.getStringTag());
    }

    public RecipesModel getModelByPosition(int pos) {
        return getRecipesModel().get(pos);
    }

    public List<RecipesModel> getRecipesModel() {
        if (recipesModel == null)
            throw new NullPointerException(RecipesModel.class.getSimpleName() + " is null");
        return recipesModel;
    }

    @SuppressWarnings("unused")
    public RecipesListener getListener() {
        return listener;
    }

    @SuppressWarnings("unused")
    public void saveRecipeModel(RecipesModel model) {
        int itemIndex = recipesModel.indexOf(model);
        if (itemIndex != -1) {
            recipesModel.set(itemIndex, model);
        }
        SharedPreferencesFactory.getInstance(getView()).writeRecipeModelToPrefs(recipesModel);
    }

    public interface RecipesListener {
        void onLoadedFromFile(List<RecipesModel> model);
    }
}
