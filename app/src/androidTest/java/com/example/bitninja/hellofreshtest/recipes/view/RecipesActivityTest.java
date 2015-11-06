package com.example.bitninja.hellofreshtest.recipes.view;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bitninja on 06.11.2015.
 */
public class RecipesActivityTest extends ActivityInstrumentationTestCase2<RecipesActivity> {

    public RecipesActivityTest(Class activityClass) {
        super(activityClass);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetPresenter() throws Exception {
        assert getActivity().getPresenter() != null;
    }
}