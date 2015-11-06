package com.example.bitninja.hellofresh.base;

import android.app.Application;
import android.os.StrictMode;

import com.example.bitninja.hellofresh.BuildConfig;
import com.example.bitninja.hellofresh.util.factory.SharedPreferencesFactory;

/**
 * Created by Bitninja.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        if (BuildConfig.DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
        super.onCreate();
        SharedPreferencesFactory.init(this);
    }
}
