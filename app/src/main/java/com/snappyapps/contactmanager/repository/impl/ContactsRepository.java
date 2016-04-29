package com.snappyapps.contactmanager.repository.impl;

import android.support.annotation.NonNull;

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
    /**
     * Adds the contacts to the database
     * @param contacts
     * @param callback
     */
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

    /**
     * Gets a default instance of the realm database
     * @return
     */
    @NonNull
    private Realm getRealm() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        return realm;
    }

    /**
     * Adds the contact to the database by id
     * @param contacts
     * @param id
     * @param callback
     */
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

    /**
     * Deletes the contact by id
     * @param id
     * @param callback
     */
    @Override
    public void deleteContactById(String id, OnDeleteContactCallback callback) {
        Realm realm = getRealm();
        Contacts contacts = realm.where(Contacts.class).equalTo(RealmTable.ID, id).findFirst();
        contacts.removeFromRealm();
        realm.commitTransaction();
    }

    /**
     * Deletes the contact by position
     * @param position
     * @param callback
     */
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

    /**
     * Gets all contacts from the database
     * @param callback
     */
    @Override
    public void getAllContacts(OnGetAllContactsCallback callback) {
        Realm realm = Realm.getDefaultInstance();
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
