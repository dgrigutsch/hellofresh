package com.example.bitninja.hellofresh.recipes.presenter;

import android.support.v4.app.FragmentManager;

import com.example.bitninja.hellofresh.recipes.model.RecipesModel;
import com.example.bitninja.hellofresh.recipes.view.RecipesActivity;
import com.example.bitninja.hellofresh.recipes.view.RecipesActivityFragment;
import com.example.bitninja.hellofresh.recipes.view.RecipesDetailFragment;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Bitninja.
 */
public class RecipesPresenterTest extends ActivityInstrumentationTestCase2<RecipesActivity> {

    private RecipesPresenter presenter;

    public RecipesPresenterTest() {
        super(RecipesActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        presenter = new RecipesPresenter(getActivity());
    }

    public void testLoadFileFromDisk() throws Exception {
        presenter.bindListener(new RecipesPresenter.RecipesListener() {
            @Override
            public void onJsonLoaded(final List<RecipesModel> model) {
                assert model != null;
            }
        });
        presenter.loadFileFromDisk();
    }

    public void testStartDetailsFragment() throws Exception {
        presenter.startDetailsFragment(-1);
        getActivity().getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                assertEquals(getActivity().getTitle(), RecipesDetailFragment.class.getSimpleName());
            }
        });
    }

    public void testStartRecipeFragment() throws Exception {
        presenter.startRecipeFragment();
        getActivity().getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                assertEquals(getActivity().getTitle(), RecipesActivityFragment.class.getSimpleName());
            }
        });
    }

    public void testGetModelByPosition() throws Exception {

        presenter.bindListener(new RecipesPresenter.RecipesListener() {
            @Override
            public void onJsonLoaded(final List<RecipesModel> model) {
                assertNull(presenter.getModelByPosition(-1));
            }
        });
        presenter.loadFileFromDisk();
    }

    public void testGetRecipesModel() throws Exception {

        presenter.bindListener(new RecipesPresenter.RecipesListener() {
            @Override
            public void onJsonLoaded(List<RecipesModel> model) {
                assertTrue (presenter.getRecipesModel().isEmpty());
            }
        });
        presenter.loadFileFromDisk();
    }

    public void testSaveRecipeModel() throws Exception {
        try {
            presenter.saveRecipeModel(null);
        }catch (final Exception e){
            assertEquals(e.getClass(),NullPointerException.class);
        }
    }
}