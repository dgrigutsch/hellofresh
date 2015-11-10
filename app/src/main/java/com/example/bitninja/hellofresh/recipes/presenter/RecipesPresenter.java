package com.example.bitninja.hellofresh.recipes.presenter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.base.BasePresenter;
import com.example.bitninja.hellofresh.recipes.model.RecipesModel;
import com.example.bitninja.hellofresh.recipes.view.RecipesActivity;
import com.example.bitninja.hellofresh.recipes.view.RecipesActivityFragment;
import com.example.bitninja.hellofresh.recipes.view.RecipesDetailFragment;
import com.example.bitninja.hellofresh.util.JSONResourceReader;
import com.example.bitninja.hellofresh.util.factory.SharedPreferencesFactory;

import java.util.Arrays;
import java.util.List;

/**
 * RecipesPresenter.
 */
public class RecipesPresenter extends BasePresenter<RecipesActivity> {

    private List<RecipesModel> recipesModel;
    private RecipesListener listener;

    /**
     *
     * @param activity activity
     */
    public RecipesPresenter(final RecipesActivity activity) {
        bindView(activity);
    }

    /**
     *  binds the Listener to the Presenter
     * @param listener listener
     */
    public void bindListener(final RecipesListener listener) {
        this.listener = listener;
    }

    /**
     * if the SharedPreferences does not contains the JsonData it will
     * load it from the File inside the Raw Folder
     */
    public void loadFileFromDisk() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(final Void... params) {
                final RecipesModel[] modelFromPrefs = SharedPreferencesFactory.getInstance().getModelFromPrefs();
                if (modelFromPrefs == null) {
                    final JSONResourceReader reader = new JSONResourceReader(getView().getResources(), R.raw.recipes);
                    final RecipesModel[] response = reader.constructUsingGson(RecipesModel[].class);
                    recipesModel = Arrays.asList(response);
                    SharedPreferencesFactory.getInstance().writeRecipeModelToPrefs(recipesModel);
                } else {
                    recipesModel = Arrays.asList(modelFromPrefs);
                }
                return null;
            }

            @Override
            protected void onPostExecute(final Void aVoid) {
                super.onPostExecute(aVoid);
                getView().hideProgressBar();
                listener.onJsonLoaded(recipesModel);
            }
        }.execute();
    }

    /**
     * starts the RecipesDetailFragment
     *
     * @param itemPosition itemPosition
     */
    public void startDetailsFragment(final int itemPosition) {

        final Bundle bundle = new Bundle();
        bundle.putInt(RecipesDetailFragment.ARG_ITEM_POSITION, itemPosition);

        final RecipesDetailFragment fragment = new RecipesDetailFragment();
        fragment.setArguments(bundle);
        final FragmentTransaction transaction = getView().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, fragment.getStringTag());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * starts the RecipesActivityFragment
     */
    public void startRecipeFragment() {

        final RecipesActivityFragment fragment = new RecipesActivityFragment();
        final FragmentTransaction transaction = getView().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, fragment.getStringTag());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * returns the RecipeModel by position
     *
     * @param pos pos
     * @return RecipeModel RecipeModel
     */
    public RecipesModel getModelByPosition(final int pos) {
        if (pos == -1)
            return null;
        return getRecipesModel().get(pos);
    }

    /**
     * returns a list with RecipesModels
     *
     * @return List<RecipesModel>
     */
    public List<RecipesModel> getRecipesModel() {
        if (recipesModel == null)
            throw new NullPointerException(RecipesModel.class.getSimpleName() + " is null");
        return recipesModel;
    }

    /**
     * saves the RecipesModel into the SharedPreferences
     *
     * @param model model
     */
    public void saveRecipeModel(final RecipesModel model) {
        if (model == null)
            throw new NullPointerException(RecipesModel.class.getSimpleName() + " is null");
        if (recipesModel == null) {
            throw new NullPointerException("variable recipesModel is not assigned");
        }
        final int itemIndex = recipesModel.indexOf(model);
        if (itemIndex != -1) {
            recipesModel.set(itemIndex, model);
        }
        SharedPreferencesFactory.getInstance().writeRecipeModelToPrefs(recipesModel);
    }

    /**
     * this Event will be called, if the Json loaded from File or SharedPreferences
     */
    public interface RecipesListener {
        void onJsonLoaded(List<RecipesModel> model);
    }
}
