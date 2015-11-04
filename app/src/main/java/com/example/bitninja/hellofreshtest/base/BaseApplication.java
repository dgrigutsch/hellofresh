package com.example.bitninja.hellofreshtest.base;

import android.app.Application;
import android.os.StrictMode;

import com.example.bitninja.hellofreshtest.BuildConfig;

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
    }
}
