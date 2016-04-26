package com.snappyapps.contactmanager.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jeromeraymond on 4/10/16.
 */
public class Contacts extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private String image;

    public Contacts() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
