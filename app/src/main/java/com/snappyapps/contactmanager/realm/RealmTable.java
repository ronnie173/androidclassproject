package com.snappyapps.contactmanager.realm;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public interface RealmTable {
    /**
     * The constant ID.
     */
    String ID = "id";

    /**
     * The interface Contact.
     */
    interface Contact{
        /**
         * The constant NAME.
         */
        String NAME = "name";
        /**
         * The constant ADDRESS.
         */
        String ADDRESS = "address";
        /**
         * The constant PHONE_NUMBER.
         */
        String PHONE_NUMBER = "phoneNumber";
        /**
         * The constant EMAIL_ADDRESS.
         */
        String EMAIL_ADDRESS = "emailAddress";
        /**
         * The constant IMAGE.
         */
        String IMAGE = "image";


    }
}
