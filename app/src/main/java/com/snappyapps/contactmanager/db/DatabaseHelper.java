package com.snappyapps.contactmanager.db;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.snappyapps.contactmanager.activities.MainActivity;
import com.snappyapps.contactmanager.models.Contacts;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by jeromeraymond on 4/11/16.
 */
public class DatabaseHelper  {

    private Realm database;
    private RealmConfiguration realmConfiguration;
    private Realm realm;
    private Context context;
    public DatabaseHelper(Realm database, Context context) {
        this.database = database;
        this.context = context;
        realmConfiguration = new RealmConfiguration.Builder(context).build();
        realm = Realm.getInstance(realmConfiguration);
    }

    public void insertData(String name, String address, String emailAddress) {
        database.beginTransaction();
        //create an object
        Contacts contacts = database.createObject(Contacts.class);
        //set the fields
        contacts.setName(name);
        contacts.setAddress(address);
        contacts.setEmailAddress(emailAddress);
       // contacts.setImage(image);
        database.commitTransaction();
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        Log.d("", "path: " + realm.getPath());
    }


}
