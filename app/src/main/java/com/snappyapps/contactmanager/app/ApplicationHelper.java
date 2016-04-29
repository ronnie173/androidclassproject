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
    RealmConfiguration config;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        try {
           config  = new RealmConfiguration
                    .Builder(getApplicationContext())
                    .setModules(new SimpleRealmModule()).build();
            Realm.setDefaultConfiguration(config);
        }catch (Exception e){
            Realm.deleteRealm(config);
        }

      //
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ApplicationHelper getInstance()
   {
       return instance;
   }
}
