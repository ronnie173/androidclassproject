package com.snappyapps.contactmanager.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snappyapps.contactmanager.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class EditContactActivityFragment extends Fragment {

    public EditContactActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_contact, container, false);
    }
}
