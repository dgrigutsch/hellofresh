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

    @Test
    public void testGetInstance() throws Exception {
        assert SharedPreferencesFactory.getInstance() != null;
    }

    @Test
    public void testWriteRecipeModelToPrefs() throws Exception {

        RecipesModel[] models = new RecipesModel[]{new RecipesModel()};
        SharedPreferencesFactory.getInstance().writeRecipeModelToPrefs(models);
    }

    @Test
    public void testGetModelFromPrefs() throws Exception {
        RecipesModel[] models = SharedPreferencesFactory.getInstance().getModelFromPrefs();
        assert models != null;
    }

}