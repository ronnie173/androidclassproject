package com.snappyapps.contactmanager.presenters;

import com.snappyapps.contactmanager.models.Contacts;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public interface IContactPresenter extends IBasePresenter {
    /**
     * Add contact.
     *
     * @param contacts the contacts
     */
    void addContact(Contacts contacts);

    /**
     * Add contact by id.
     *
     * @param contact   the contact
     * @param contactId the contact id
     */
    void addContactById(Contacts contact, String contactId);

    /**
     * Delete contact by position.
     *
     * @param position the position
     */
    void deleteContactByPosition(int position);

    /**
     * Delete contact by id.
     *
     * @param studentId the student id
     */
    void deleteContactById(String studentId);

    /**
     * Gets all contacts.
     */
    void getAllContacts();

    /**
     * Gets all contacts by id.
     *
     * @param id the id
     */
    void getAllContactsById(String id);

    /**
     * Gets contact by id.
     *
     * @param id the id
     */
    void getContactById(String id);


}
