package com.example.bitninja.hellofresh.recipes.presenter;

import android.app.Instrumentation;
import android.test.InstrumentationTestCase;

import com.example.bitninja.hellofresh.recipes.view.RecipesActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bitninja.
 */
public class RecipesPresenterTest extends InstrumentationTestCase{

    private RecipesPresenter presenter;
    private RecipesActivity mActivity;
    private Instrumentation mInstrumentation;

    @Before
    public void setUp() throws Exception {
        mInstrumentation = getInstrumentation();
        presenter = new RecipesPresenter();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBindListener() throws Exception {

    }

    @Test
    public void testLoadFileFromDisk() throws Exception {

    }

    @Test
    public void testStartDetailsFragment() throws Exception {

    }

    @Test
    public void testStartRecipeFragment() throws Exception {

    }

    @Test
    public void testGetModelByPosition() throws Exception {

    }

    @Test
    public void testGetRecipesModel() throws Exception {

    }

    @Test
    public void testGetListener() throws Exception {

    }

    @Test
    public void testSaveRecipeModel() throws Exception {

    }
}