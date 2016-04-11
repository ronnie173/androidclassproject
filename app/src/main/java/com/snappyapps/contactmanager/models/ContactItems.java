package com.snappyapps.contactmanager.models;

/**
 * Created by jeromeraymond on 4/10/16.
 */
public class ContactItems {
    private String name;
    private int photo;

    public ContactItems(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
