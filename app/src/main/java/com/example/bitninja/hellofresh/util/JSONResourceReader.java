package com.example.bitninja.hellofresh.util;

/**
 * Created by Bitninja.
 */

import android.content.res.Resources;
import android.util.Log;

import com.example.bitninja.hellofresh.util.factory.GsonFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * An object for reading from a JSON resource file and constructing an object from that resource file using Gson.
 */
public final class JSONResourceReader {
    private static final String CHARSET_NAME = "UTF-8";
    private static final String LOG_TAG = JSONResourceReader.class.getSimpleName();
    private final Resources resources;
    private final int resId;

    public JSONResourceReader(final Resources resources, final int resId) {
        this.resId = resId;
        this.resources = resources;
    }

    /**
     * Build an object from the specified JSON resource using Gson.
     *
     * @param type The type of the object to build.
     *
     * @return An object of type T, with member fields populated using Gson.
     */
    public <T> T constructUsingGson(final Class<T> type) {
        final InputStream resourceReader = resources.openRawResource(resId);
        T obj = null;
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, CHARSET_NAME));
            obj = GsonFactory.getInstance().getGson().fromJson(reader, type);
        } catch (final Exception e) {
            Log.e(LOG_TAG, "Unhandled exception while using JSONResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (final Exception e) {
                Log.e(LOG_TAG, "Unhandled exception while using JSONResourceReader", e);
            }
        }
        return obj;
    }
}