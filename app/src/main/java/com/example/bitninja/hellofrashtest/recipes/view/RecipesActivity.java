package com.example.bitninja.hellofrashtest.recipes.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.base.BaseActivity;
import com.example.bitninja.hellofrashtest.recipes.presenter.RecipesPresenter;

public class RecipesActivity extends BaseActivity<RecipesPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        presenter = new RecipesPresenter(this);
        RecipesActivityFragment fragment = (RecipesActivityFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (fragment != null) {
            presenter.loadFileFromDisk(fragment);
        }
    }

    @Override
    public RecipesPresenter getPresenter() {
        return presenter;
    }
}
