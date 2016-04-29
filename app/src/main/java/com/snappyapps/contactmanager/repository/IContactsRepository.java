package com.snappyapps.contactmanager.repository;

import com.snappyapps.contactmanager.models.Contacts;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public interface IContactsRepository {
    /**
     * The interface On save contact callback.
     */
    interface OnSaveContactCallback {
        /**
         * On success.
         */
        void onSuccess();

        /**
         * On error.
         *
         * @param message the message
         */
        void onError(String message);
    }

    /**
     * The interface On delete contact callback.
     */
    interface OnDeleteContactCallback {
        /**
         * On success.
         */
        void onSuccess();

        /**
         * On error.
         *
         * @param message the message
         */
        void onError(String message);
    }

    /**
     * The interface On get contact by id callback.
     */
    interface OnGetContactByIdCallback {
        /**
         * On success.
         *
         * @param contacts the contacts
         */
        void onSuccess(Contacts contacts);

        /**
         * On error.
         *
         * @param message the message
         */
        void onError(String message);
    }

    /**
     * The interface On get all contacts callback.
     */
    interface OnGetAllContactsCallback {
        /**
         * On success.
         *
         * @param Contacts the contacts
         */
        void onSuccess(RealmResults<Contacts> Contacts);

        /**
         * On error.
         *
         * @param message the message
         */
        void onError(String message);
    }

    /**
     * The interface On get contacts callback.
     */
    interface OnGetContactsCallback{
        /**
         * On success.
         *
         * @param Contacts the contacts
         */
        void onSuccess(RealmList<Contacts> Contacts);

        /**
         * On error.
         *
         * @param message the message
         */
        void onError(String message);
    }

    /**
     * Add contact.
     *
     * @param contacts the contacts
     * @param callback the callback
     */
    void addContact(Contacts contacts, OnSaveContactCallback callback);

    /**
     * Add contact by id.
     *
     * @param contacts the contacts
     * @param id       the id
     * @param callback the callback
     */
    void addContactById(Contacts contacts, String id, OnSaveContactCallback callback);

    /**
     * Delete contact by id.
     *
     * @param id       the id
     * @param callback the callback
     */
    void deleteContactById(String id, OnDeleteContactCallback callback);

    /**
     * Delete contact by position.
     *
     * @param position the position
     * @param callback the callback
     */
    void deleteContactByPosition(int position, OnDeleteContactCallback callback);

    /**
     * Gets all contacts.
     *
     * @param callback the callback
     */
    void getAllContacts(OnGetAllContactsCallback callback);

    /**
     * Gets all contacts by university id.
     *
     * @param id       the id
     * @param callback the callback
     */
    void getAllContactsByUniversityId(String id, OnGetContactsCallback callback);

    /**
     * Gets contact by id.
     *
     * @param id       the id
     * @param callback the callback
     */
    void getContactById(String id, OnGetContactByIdCallback callback);

}
