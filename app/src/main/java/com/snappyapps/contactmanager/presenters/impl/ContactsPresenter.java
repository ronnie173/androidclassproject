package com.snappyapps.contactmanager.presenters.impl;

import android.content.Intent;

import com.snappyapps.contactmanager.activities.MainActivity;
import com.snappyapps.contactmanager.models.Contacts;
import com.snappyapps.contactmanager.presenters.IContactPresenter;
import com.snappyapps.contactmanager.repository.IContactsRepository;
import com.snappyapps.contactmanager.repository.impl.ContactsRepository;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public class ContactsPresenter implements IContactPresenter {

    private MainActivity view;
    private IContactsRepository.OnDeleteContactCallback onDeleteContactCallback;
    private IContactsRepository.OnSaveContactCallback onSaveContactCallback;
    private IContactsRepository.OnGetAllContactsCallback onGetAllContactsCallback;
    private IContactsRepository.OnGetContactByIdCallback onGetContactByIdCallback;
    private IContactsRepository.OnGetContactsCallback onGetContactsCallback;
    private IContactsRepository contactsRepository;

    public ContactsPresenter(MainActivity view) {
        this.view = view;
        contactsRepository = new ContactsRepository();
    }

    @Override
    public void addContact(Contacts contacts) {
        contactsRepository.addContact(contacts, onSaveContactCallback);
    }

    @Override
    public void addContactById(Contacts contact, String contactId) {
        contactsRepository.addContactById(contact, contactId, onSaveContactCallback);
    }

    @Override
    public void deleteContactByPosition(int position) {
        contactsRepository.deleteContactByPosition(position, onDeleteContactCallback);
    }

    @Override
    public void deleteContactById(String ContactId) {
        contactsRepository.deleteContactById(ContactId, onDeleteContactCallback);
    }

    @Override
    public void getAllContacts() {
        contactsRepository.getAllContacts(onGetAllContactsCallback);
    }

    @Override
    public void getAllContactsById(String id) {

    }

    @Override
    public void getContactById(String id) {

    }

    @Override
    public void subscribeCallbacks() {
        onSaveContactCallback = new IContactsRepository.OnSaveContactCallback() {
            @Override
            public void onSuccess() {
                Intent intent = view.getIntent();
                view.showMessage("Added");
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                view.finish();
                view.startActivity(view.getIntent());

            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onDeleteContactCallback = new IContactsRepository.OnDeleteContactCallback() {

            @Override
            public void onSuccess() {
                view.showMessage("Deleted");
            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onGetAllContactsCallback = new IContactsRepository.OnGetAllContactsCallback() {

            @Override
            public void onSuccess(RealmResults<Contacts> Contacts) {
                view.showResults(Contacts);
            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onGetContactByIdCallback = new IContactsRepository.OnGetContactByIdCallback() {

            @Override
            public void onSuccess(Contacts contacts) {

            }

            @Override
            public void onError(String message) {

            }
        };

        onGetContactsCallback = new IContactsRepository.OnGetContactsCallback() {

            @Override
            public void onSuccess(RealmList<Contacts> contacts) {

            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onGetContactByIdCallback = new IContactsRepository.OnGetContactByIdCallback() {
            @Override
            public void onSuccess(Contacts contacts) {

            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };

    }

    @Override
    public void unsubscribeCallbacks() {
        onDeleteContactCallback = null;
        onSaveContactCallback = null;
        onGetAllContactsCallback = null;
        onGetContactByIdCallback = null;
    }
}
