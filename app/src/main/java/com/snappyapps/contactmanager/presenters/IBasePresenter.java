package com.snappyapps.contactmanager.presenters;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public interface IBasePresenter {
    /**
     * Subscribe callbacks.
     */
    void subscribeCallbacks();

    /**
     * Unsubscribe callbacks.
     */
    void unsubscribeCallbacks();
}
