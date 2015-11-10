package com.example.bitninja.hellofresh;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Bitninja.
 */
public class RestServiceTestHelper {

    private static String convertStreamToString(final InputStream is) throws Exception {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        final StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile(final Context context, final String filePath) throws Exception {
        final InputStream stream = context.getResources().getAssets().open(filePath);
        if(stream==null)
            throw new NullPointerException("InputStream is null");
        final String ret = convertStreamToString(stream);
        stream.close();
        return ret;
    }
}
