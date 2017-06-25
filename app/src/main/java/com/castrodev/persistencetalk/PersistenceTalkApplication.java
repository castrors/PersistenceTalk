package com.castrodev.persistencetalk;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by rodrigocastro on 25/06/17.
 */

public class PersistenceTalkApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
