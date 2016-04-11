package com.snappyapps.contactmanager;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by jeromeraymond on 4/11/16.
 */
public class ApplicationHelper extends Application {
    private static Realm database;
    @Override
    public void onCreate() {
        super.onCreate();
        database = Realm.getInstance(new RealmConfiguration.Builder(this)
                .name("database.realm")
                .build());
    }

    public static Realm getDatabaseInstance() {
        return database;
    }
}
