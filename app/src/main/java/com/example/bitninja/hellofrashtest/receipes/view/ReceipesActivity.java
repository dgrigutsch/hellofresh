package com.example.bitninja.hellofrashtest.receipes.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.base.BaseActivity;
import com.example.bitninja.hellofrashtest.receipes.model.ReceipesModel;
import com.example.bitninja.hellofrashtest.receipes.presenter.ReceipesPresenter;

import java.util.List;

public class ReceipesActivity extends BaseActivity implements ReceipesPresenter.ReceipesListener {

    private ReceipesPresenter presenter;

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
        presenter = new ReceipesPresenter(this);
        presenter.loadFileFromDisk(this);
    }

    @Override
    public void onLoadedFromFile(List<ReceipesModel> model) {

        ReceipesActivityFragment fragment = (ReceipesActivityFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment);
        if(fragment!=null){
            fragment.onUpdateReceipes(model);
        }
//        else {
//            ReceipesActivityFragment newFragment = new ReceipesActivityFragment();
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            // Replace whatever is in the fragment_container view with this fragment,
//            // and add the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.fragment_container, newFragment);
//            transaction.addToBackStack(null);
//            // Commit the transaction
//            transaction.commit();
//        }
    }
}
