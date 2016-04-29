package com.snappyapps.contactmanager.models;

/**
 * Created by jeromeraymond on 4/10/16.
 */
public class ContactItems {
    private String name;
    private String userAddress;
    private String userPhoneNumber;
    private String userEmailAddress;
    private int photo;

    /**
     * Instantiates a new Contact items.
     *
     * @param name  the name
     * @param photo the photo
     */
    public ContactItems(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets photo.
     *
     * @return the photo
     */
    public int getPhoto() {
        return photo;
    }

    /**
     * Sets photo.
     *
     * @param photo the photo
     */
    public void setPhoto(int photo) {
        this.photo = photo;
    }

    /**
     * Gets user address.
     *
     * @return the user address
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * Sets user address.
     *
     * @param userAddress the user address
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * Gets user phone number.
     *
     * @return the user phone number
     */
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    /**
     * Sets user phone number.
     *
     * @param userPhoneNumber the user phone number
     */
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    /**
     * Gets user email address.
     *
     * @return the user email address
     */
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    /**
     * Sets user email address.
     *
     * @param userEmailAddress the user email address
     */
    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }
}
