package com.snappyapps.contactmanager.db;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.snappyapps.contactmanager.activities.MainActivity;
import com.snappyapps.contactmanager.models.Contacts;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by jeromeraymond on 4/11/16.
 */
public class DatabaseHelper  {

    private static final String TAG = DatabaseHelper.class.getSimpleName();
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

    public void insertData(final String name, final String address, final String emailAddress,final String phoneNumber) {
        realm.beginTransaction();
        Contacts contacts = database.createObject(Contacts.class);
        contacts.setName(name);
        contacts.setAddress(address);
        contacts.setEmailAddress(emailAddress);
        contacts.setPhoneNumber(phoneNumber);
        realm.commitTransaction();

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        Log.d("", "path: " + realm.getPath());

    }


    public void queryDatabase(int position)
    {
        // Build the query looking at all users:
        RealmQuery<Contacts> query = realm.where(Contacts.class);
        query.equalTo("id",position);
        RealmResults<Contacts> results = query.findAll();
        for (int i = 0; i < results.size(); i++) {
            Contacts u = results.get(i);
            Log.d(TAG,u.getAddress());
        }


    }


}
