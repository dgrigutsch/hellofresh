package com.example.bitninja.hellofreshtest.factory;

import android.test.ApplicationTestCase;

import com.example.bitninja.hellofreshtest.base.BaseApplication;
import com.example.bitninja.hellofreshtest.recipes.model.RecipesModel;
import com.example.bitninja.hellofreshtest.util.factory.SharedPreferencesFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bitninja.
 */
public class SharedPreferencesFactoryTest extends ApplicationTestCase<BaseApplication> {


    public SharedPreferencesFactoryTest(Class<BaseApplication> applicationClass) {
        super(applicationClass);
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