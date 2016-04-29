package com.snappyapps.contactmanager.app;

import android.app.Application;

import com.snappyapps.contactmanager.realm.SimpleRealmModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by jeromeraymond on 4/11/16.
 */
public class ApplicationHelper extends Application {
    private static ApplicationHelper instance;
    public static RealmConfiguration config;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        config = new RealmConfiguration
                .Builder(getApplicationContext()).deleteRealmIfMigrationNeeded()
                .setModules(new SimpleRealmModule()).build();
        Realm.setDefaultConfiguration(config);


    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ApplicationHelper getInstance() {
        return instance;
    }
    public static RealmConfiguration realmConfig()
    {
        return config;
    }
}
