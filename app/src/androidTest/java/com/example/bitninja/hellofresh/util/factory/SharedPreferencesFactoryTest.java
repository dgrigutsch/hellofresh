package com.example.bitninja.hellofresh.util.factory;

import android.test.ApplicationTestCase;

import com.example.bitninja.hellofresh.base.BaseApplication;
import com.example.bitninja.hellofresh.recipes.model.RecipesModel;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bitninja.
 */
public class SharedPreferencesFactoryTest extends ApplicationTestCase<BaseApplication> {


    public SharedPreferencesFactoryTest() {
        super(BaseApplication.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        SharedPreferencesFactory.init(getContext());
    }

    public void testGetInstance() throws Exception {
        assert SharedPreferencesFactory.getInstance() != null;
    }

    public void testWriteRecipeModelToPrefs() throws Exception {

        final RecipesModel[] models = {new RecipesModel()};
        SharedPreferencesFactory.getInstance().writeRecipeModelToPrefs(models);
    }

    public void testGetModelFromPrefs() throws Exception {
        final RecipesModel[] models = SharedPreferencesFactory.getInstance().getModelFromPrefs();
        assert models != null;
    }

}