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
import java.io.StringWriter;
import java.io.Writer;

/**
 * An object for reading from a JSON resource file and constructing an object from that resource file using Gson.
 */
public class JSONResourceReader {
    private static final String CHARSET_NAME = "UTF-8";
    private static final String LOGTAG = JSONResourceReader.class.getSimpleName();
    private Resources resources;
    private int resId;

    public JSONResourceReader(Resources resources, int resId) {
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
    public <T> T constructUsingGson(Class<T> type) {
        InputStream resourceReader = resources.openRawResource(resId);
        T obj = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, CHARSET_NAME));
            obj = GsonFactory.getInstance().getGson().fromJson(reader, type);
        } catch (Exception e) {
            Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
            }
        }
        return obj;
    }
}