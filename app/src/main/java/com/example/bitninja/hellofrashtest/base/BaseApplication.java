package com.example.bitninja.hellofrashtest.base;

import android.app.Application;
import android.os.StrictMode;

import com.example.bitninja.hellofrashtest.BuildConfig;

/**
 * Created by Bitninja on 27.10.2015.
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
