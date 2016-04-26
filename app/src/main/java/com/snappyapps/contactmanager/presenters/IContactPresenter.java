package com.snappyapps.contactmanager.presenters;

import com.snappyapps.contactmanager.models.Contacts;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public interface IContactPresenter extends IBasePresenter {
    void addContact(Contacts contacts);

    void addContactById(Contacts contact, String contactId);

    void deleteContactByPosition(int position);

    void deleteContactById(String studentId);

    void getAllContacts();

    void getAllContactsById(String id);

    void getContactById(String id);


}
