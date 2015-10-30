package com.example.bitninja.hellofreshtest.recipes.presenter;

import android.os.AsyncTask;

import com.example.bitninja.hellofreshtest.R;
import com.example.bitninja.hellofreshtest.base.BaseActivity;
import com.example.bitninja.hellofreshtest.base.BasePresenter;
import com.example.bitninja.hellofreshtest.recipes.model.RecipesModel;
import com.example.bitninja.hellofreshtest.utils.JSONResourceReader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class RecipesPresenter extends BasePresenter<BaseActivity> {

    private List<RecipesModel> receipesModel;

    public RecipesPresenter(BaseActivity activity) {
        bindView(activity);
    }

    public void loadFileFromDisk(final ReceipesListener listener) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                JSONResourceReader reader = new JSONResourceReader(getView().getResources(), R.raw.recipes);
                RecipesModel[] response = reader.constructUsingGson(RecipesModel[].class);
                receipesModel = Arrays.asList(response);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                listener.onLoadedFromFile(receipesModel);
            }
        }.execute();
    }

    public List<RecipesModel> getReceipesModel() {
        if (receipesModel == null)
            throw new NullPointerException(RecipesModel.class.getSimpleName() + " is null");
        return receipesModel;
    }

    public interface ReceipesListener {
        void onLoadedFromFile(List<RecipesModel> model);
    }
}
