package com.example.bitninja.hellofresh.util.factory;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bitninja.hellofresh.recipes.model.RecipesModel;

import java.util.List;

/**
 * SharedPreferencesFactory.
 */
public class SharedPreferencesFactory {

    private static final String PREFS_JSON_FILE = "prefs_json_file";
    private static final String PREFS_FAV_RECIPE = "prefs_fav_recipe_";
    private static SharedPreferencesFactory _ourInstance;
    private final SharedPreferences preferences;

    private SharedPreferencesFactory(final Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * creates a Instance of the SharedPreferencesFactory
     * must be done before calling getInstance
     *
     * @param context Context
     * @return SharedPreferencesFactory SharedPreferencesFactory
     */
    public static SharedPreferencesFactory init(final Context context) {
        if (_ourInstance == null) {
            _ourInstance = new SharedPreferencesFactory(context);
        }
        return _ourInstance;
    }

    /**
     * returns the Instance of SharedPreferencesFactory
     *
     * @return SharedPreferencesFactory instance
     */
    public static SharedPreferencesFactory getInstance() {
        if (_ourInstance == null)
            throw new NullPointerException(SharedPreferencesFactory.class.getSimpleName()
                    + " method init must be called first");
        return _ourInstance;
    }

    /**
     * saves the List of RecipesModels into the SharedPreferences
     *
     * @param model model
     */
    public void writeRecipeModelToPrefs(final List<RecipesModel> model) {
        writeRecipeModelToPrefs(model.toArray(new RecipesModel[model.size()]));
    }

    /**
     * saves the List of RecipesModels into the SharedPreferences
     *
     * @param model model
     */
    public void writeRecipeModelToPrefs(final RecipesModel[] model) {
        final String value = GsonFactory.getInstance().getGson().toJson(model, RecipesModel[].class);
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREFS_JSON_FILE, value);
        editor.apply();
    }

    /**
     * returns a List of RecipesModels from the SharedPreferences
     *
     * @return RecipesModel[] RecipesModel
     */
    public RecipesModel[] getModelFromPrefs() {
        final String value = preferences.getString(PREFS_JSON_FILE, "");
        if (value.isEmpty())
            return null;
        return GsonFactory.getInstance().getGson().fromJson(value, RecipesModel[].class);
    }

    /**
     * returns the current MarkState of the Recipe
     *
     * @param key key
     * @return boolean mark
     */
    public boolean getMarkState(final String key) {
        return preferences.getBoolean(PREFS_FAV_RECIPE + key, false);
    }

    /**
     * marks a Recipe as Favorite
     *
     * @param key key
     */
    public void markAsFavorite(final String key) {
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFS_FAV_RECIPE + key, true);
        editor.apply();
    }

    /**
     * removes a Recipe as Favorite
     *
     * @param key key
     */
    public void unmaskAsFavorite(final String key) {
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFS_FAV_RECIPE + key, false);
        editor.apply();
    }
}
