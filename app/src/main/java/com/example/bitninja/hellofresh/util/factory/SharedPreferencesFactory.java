package com.example.bitninja.hellofresh.util.factory;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bitninja.hellofresh.recipes.model.RecipesModel;

import java.util.List;

/**
 * Created by Bitninja.
 */
public class SharedPreferencesFactory {

    private static final String PREFS_JSON_FILE = "prefs_json_file";
    private static final String PREFS_FAV_RECIPE = "prefs_fav_recipe_";
    private static SharedPreferencesFactory _ourInstance;
    private SharedPreferences preferences;

    private SharedPreferencesFactory(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferencesFactory init(Context context) {
        if (_ourInstance == null) {
            _ourInstance = new SharedPreferencesFactory(context);
        }
        return _ourInstance;
    }

    public static SharedPreferencesFactory getInstance() {
        if (_ourInstance == null)
            throw new NullPointerException(SharedPreferencesFactory.class.getSimpleName()
                    + " method init must be called first");
        return _ourInstance;
    }

    public void writeRecipeModelToPrefs(List<RecipesModel> model) {
        writeRecipeModelToPrefs(model.toArray(new RecipesModel[model.size()]));
    }

    public void writeRecipeModelToPrefs(RecipesModel[] model) {
        String value = GsonFactory.getInstance().getGson().toJson(model, RecipesModel[].class);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREFS_JSON_FILE, value);
        editor.apply();
    }

    public RecipesModel[] getModelFromPrefs() {
        String value = preferences.getString(PREFS_JSON_FILE, "");
        if (value.isEmpty())
            return null;
        return GsonFactory.getInstance().getGson().fromJson(value, RecipesModel[].class);
    }

    public boolean getMarkState(String key) {
        return preferences.getBoolean(PREFS_FAV_RECIPE + key, false);
    }

    public void markAsFavorite(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFS_FAV_RECIPE + key, true);
        editor.apply();
    }

    public void unmarkAsFavorite(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFS_FAV_RECIPE + key, false);
        editor.apply();
    }
}
