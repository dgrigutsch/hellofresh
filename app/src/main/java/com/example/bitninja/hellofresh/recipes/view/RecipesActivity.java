package com.example.bitninja.hellofresh.recipes.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.bitninja.hellofresh.R;
import com.example.bitninja.hellofresh.base.BaseActivity;
import com.example.bitninja.hellofresh.login.view.LoginActivity;
import com.example.bitninja.hellofresh.recipes.presenter.RecipesPresenter;
import com.example.bitninja.hellofresh.util.factory.GsonFactory;
import com.google.gson.Gson;

public class RecipesActivity extends BaseActivity<RecipesPresenter> {

    private static final String PRESENTER_DATA = "presenterData";
    private ContentLoadingProgressBar progressBar;
    private FrameLayout container;
    private Gson gson;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipes);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gson =  GsonFactory.getInstance().getGson();
        container = (FrameLayout) findViewById(R.id.container);
        container.setVisibility(View.GONE);
        progressBar = (ContentLoadingProgressBar) findViewById(R.id.setup_progress);
        progressBar.show();

        if(presenter == null)
            presenter = new RecipesPresenter(this);
        presenter.bindView(this);
        presenter.startRecipeFragment();
    }

    @Override
    public RecipesPresenter getPresenter() {
        return presenter;
    }

    /**
     * it's hides the ProgressBar
     */
    public void hideProgressBar() {
        if (progressBar != null)
            progressBar.hide();
        container.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_receipes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        final int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {

            final Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
