package com.example.bitninja.hellofresh.recipes.view;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RecipesActivityTest.
 */
public class RecipesActivityTest extends ActivityInstrumentationTestCase2<RecipesActivity> {

    public RecipesActivityTest() {
        super(RecipesActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {

    }

    public void testGetPresenter() throws Exception {
        assert getActivity().getPresenter() != null;
    }
}