package com.snappyapps.contactmanager.repository.impl;

import android.support.annotation.NonNull;

import com.snappyapps.contactmanager.app.ApplicationHelper;
import com.snappyapps.contactmanager.models.Contacts;
import com.snappyapps.contactmanager.realm.RealmTable;
import com.snappyapps.contactmanager.repository.IContactsRepository;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public class ContactsRepository implements IContactsRepository {

    @Override
    public void addContact(Contacts contacts, OnSaveContactCallback callback) {
        Realm realm = getRealm();
        Contacts contact = realm.createObject(Contacts.class);
        contact.setId(UUID.randomUUID().toString());
        contact.setName(contacts.getName());
        contact.setAddress(contacts.getAddress());
        contact.setPhoneNumber(contacts.getPhoneNumber());
        contact.setEmailAddress(contacts.getEmailAddress());
        contact.setImage(contacts.getImage());
        realm.commitTransaction();
        if (callback != null)
            callback.onSuccess();
    }

    @NonNull
    private Realm getRealm() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        return realm;
    }

    @Override
    public void addContactById(Contacts contacts, String id, OnSaveContactCallback callback) {
        Realm realm = getRealm();
        Contacts contact = realm.createObject(Contacts.class);
        contact.setId(UUID.randomUUID().toString());
        contact.setName(contacts.getName());
        contact.setAddress(contacts.getAddress());
        contact.setPhoneNumber(contacts.getPhoneNumber());
        contact.setEmailAddress(contacts.getEmailAddress());
        contact.setImage(contacts.getImage());


        realm.commitTransaction();
        if (callback != null)
            callback.onSuccess();

    }

    @Override
    public void deleteContactById(String id, OnDeleteContactCallback callback) {
        Realm realm = getRealm();
        Contacts contacts = realm.where(Contacts.class).equalTo(RealmTable.ID, id).findFirst();
        contacts.removeFromRealm();
        realm.commitTransaction();
    }

    @Override
    public void deleteContactByPosition(int position, OnDeleteContactCallback callback) {
        Realm realm = getRealm();
        RealmQuery<Contacts> query = realm.where(Contacts.class);
        RealmResults<Contacts> results = query.findAll();
        results.remove(position);
        realm.commitTransaction();

        if (callback != null)
            callback.onSuccess();
    }

    @Override
    public void getAllContacts(OnGetAllContactsCallback callback) {
        Realm realm = Realm.getInstance(ApplicationHelper.getInstance());
        RealmQuery<Contacts> query = realm.where(Contacts.class);
        RealmResults<Contacts> results = query.findAll();

        if (callback != null)
            callback.onSuccess(results);
    }

    @Override
    public void getAllContactsByUniversityId(String id, OnGetContactsCallback callback) {

    }

    @Override
    public void getContactById(String id, OnGetContactByIdCallback callback) {

    }
}
