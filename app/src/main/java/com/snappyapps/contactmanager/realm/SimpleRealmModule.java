package com.snappyapps.contactmanager.realm;

import com.snappyapps.contactmanager.models.Contacts;

import io.realm.annotations.RealmModule;

/**
 * Created by jeromeraymond on 4/25/16.
 */
@RealmModule(classes = {Contacts.class})
public class SimpleRealmModule {
}
