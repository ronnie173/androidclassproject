package com.snappyapps.contactmanager.realm;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public interface RealmTable {
    String ID = "id";
    interface Contact{
        String NAME = "name";
        String ADDRESS = "address";
        String PHONE_NUMBER = "phoneNumber";
        String EMAIL_ADDRESS = "emailAddress";
        String IMAGE = "image";


    }
}
