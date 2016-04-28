package com.snappyapps.contactmanager.fragments;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.models.Contacts;
import com.snappyapps.contactmanager.realm.RealmTable;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShowContactActivityFragment extends Fragment implements OnMapReadyCallback {
    Bundle bundle;
    private Contacts contact;

    public ShowContactActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            contact = getContact(bundle.getString("id"));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_show_contact, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Geocoder geocoder = new Geocoder(getActivity(), Locale.ENGLISH);
        double lat = 0;
        double lng = 0;
        try {
            List<Address> list = geocoder.getFromLocationName(contact.getAddress(), 1);
            Address address = list.get(0);

            lat = address.getLatitude();
            lng = address.getLongitude();

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lng)));
            googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(contact.getName() + "'s Location"));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 3000, null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private Contacts getContact(String id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Contacts contact = realm.where(Contacts.class).equalTo(RealmTable.ID, id).findFirst();
        realm.commitTransaction();

        return contact;
    }


}
