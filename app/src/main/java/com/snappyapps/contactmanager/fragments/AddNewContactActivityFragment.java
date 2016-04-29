package com.snappyapps.contactmanager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snappyapps.contactmanager.R;
/**
 * Created by jeromeraymond on 4/11/16.
 */

/**
 * A placeholder fragment containing a simple view.
 */
public class AddNewContactActivityFragment extends Fragment {

    /**
     * Instantiates a new Add new contact activity fragment.
     */
    public AddNewContactActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_contact, container, false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.fragment));
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();

    }
}
