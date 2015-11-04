package com.example.bitninja.hellofreshtest.util.factory;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bitninja.hellofreshtest.recipes.model.RecipesModel;

import java.util.List;

/**
 * Created by Bitninja.
 */
public class SharedPreferencesFactory {

    private static final String PREFS_JSON_FILE = "prefs_json_file";
    private static SharedPreferencesFactory _ourInstance;
    private SharedPreferences preferences;

    private SharedPreferencesFactory(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferencesFactory getInstance(Context context) {
        if (_ourInstance == null) {
            _ourInstance = new SharedPreferencesFactory(context);
        }
        return _ourInstance;
    }

    public void writeRecipeModelToPrefs(List<RecipesModel> model) {
        writeRecipeModelToPrefs(model.toArray(new RecipesModel[model.size()]));
    }

    private void writeRecipeModelToPrefs(RecipesModel[] model) {
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
}
