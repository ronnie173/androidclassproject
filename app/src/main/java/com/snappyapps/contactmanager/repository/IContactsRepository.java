package com.snappyapps.contactmanager.repository;

import com.snappyapps.contactmanager.models.Contacts;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public interface IContactsRepository {
    interface OnSaveContactCallback {
        void onSuccess();
        void onError(String message);
    }

    interface OnDeleteContactCallback {
        void onSuccess();
        void onError(String message);
    }

    interface OnGetContactByIdCallback {
        void onSuccess(Contacts contacts);
        void onError(String message);
    }

    interface OnGetAllContactsCallback {
        void onSuccess(RealmResults<Contacts> Contacts);
        void onError(String message);
    }

    interface OnGetContactsCallback{
        void onSuccess(RealmList<Contacts> Contacts);
        void onError(String message);
    }

    void addContact(Contacts contacts, OnSaveContactCallback callback);

    void addContactById(Contacts contacts, String id, OnSaveContactCallback callback);

    void deleteContactById(String id, OnDeleteContactCallback callback);

    void deleteContactByPosition(int position, OnDeleteContactCallback callback);

    void getAllContacts(OnGetAllContactsCallback callback);

    void getAllContactsByUniversityId(String id, OnGetContactsCallback callback);

    void getContactById(String id, OnGetContactByIdCallback callback);

}
