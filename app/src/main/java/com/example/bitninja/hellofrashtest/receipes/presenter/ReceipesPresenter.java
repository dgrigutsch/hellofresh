package com.example.bitninja.hellofrashtest.receipes.presenter;

import android.os.Handler;

import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.base.BaseActivity;
import com.example.bitninja.hellofrashtest.receipes.model.ReceipesModel;
import com.example.bitninja.hellofrashtest.utils.JSONResourceReader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class ReceipesPresenter {

    private BaseActivity view;
    private List<ReceipesModel> receipesModel;

    public ReceipesPresenter(BaseActivity activity) {
        view = activity;
    }

    public void loadFileFromDisk(final ReceipesListener listener) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                JSONResourceReader reader = new JSONResourceReader(view.getResources(), R.raw.recipes);
                ReceipesModel[] response = reader.constructUsingGson(ReceipesModel[].class);
                receipesModel = Arrays.asList(response);
                listener.onLoadedFromFile(receipesModel);
            }
        });
    }

    public List<ReceipesModel> getReceipesModel() {
        if (receipesModel == null)
            throw new NullPointerException(ReceipesModel.class.getSimpleName() + " is null");
        return receipesModel;
    }

    public interface ReceipesListener {
        void onLoadedFromFile(List<ReceipesModel> model);
    }
}
