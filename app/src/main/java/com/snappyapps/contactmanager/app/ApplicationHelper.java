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
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RealmConfiguration config = new RealmConfiguration
                .Builder(getApplicationContext())
                .setModules(new SimpleRealmModule()).build();
        Realm.setDefaultConfiguration(config);
      //  Realm.deleteRealm(config);
    }

   public static ApplicationHelper getInstance()
   {
       return instance;
   }
}
