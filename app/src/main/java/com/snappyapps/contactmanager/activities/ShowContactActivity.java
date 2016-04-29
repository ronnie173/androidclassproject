package com.snappyapps.contactmanager.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.models.Contacts;
import com.snappyapps.contactmanager.realm.RealmTable;

import io.realm.Realm;
/**
 * Created by jeromeraymond on 4/11/16.
 */
/**
 * The type Show contact activity.
 */
public class ShowContactActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ShowContactActivity.class.getSimpleName();
    /**
     * The Photo image view.
     */
    ImageView photoImageView;
    /**
     * The Name tv.
     */
    TextView nameTv;
    /**
     * The Phone number tv.
     */
    TextView phoneNumberTv;
    /**
     * The Address tv.
     */
    TextView addressTv;
    /**
     * The Email address.
     */
    TextView emailAddress;
    /**
     * The Phone call btn.
     */
    ImageButton phoneCallBtn;
    /**
     * The Mail btn.
     */
    ImageButton mailBtn;
    /**
     * The Contact.
     */
    Contacts contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initComponents();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            contact = getContact(extras.getString("id"));
            nameTv.setText(contact.getName());
            phoneNumberTv.setText(contact.getPhoneNumber());
            addressTv.setText(contact.getAddress());
            emailAddress.setText(contact.getEmailAddress());

        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), EditContactActivity.class);
                intent.putExtra(RealmTable.ID, contact.getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    private void initComponents() {
        photoImageView = (ImageView) findViewById(R.id.photoImageView);
        nameTv = (TextView) findViewById(R.id.nameTv);
        phoneNumberTv = (TextView) findViewById(R.id.phoneTv);
        addressTv = (TextView) findViewById(R.id.addressTv);
        emailAddress = (TextView) findViewById(R.id.emailTxv);
        phoneCallBtn = (ImageButton) findViewById(R.id.callBtn);
        mailBtn = (ImageButton) findViewById(R.id.mailBtn);
        phoneCallBtn.setOnClickListener(this);
        mailBtn.setOnClickListener(this);
    }

    private Contacts getContact(String id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Contacts contact = realm.where(Contacts.class).equalTo(RealmTable.ID, id).findFirst();
        realm.commitTransaction();

        return contact;
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.callBtn:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
                Log.d(TAG, contact.getPhoneNumber());
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                    return;
                }
                break;
            case R.id.mailBtn:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:" ));
                intent.setType("text/plain");
                Log.d(TAG, contact.getPhoneNumber());
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                    return;
                }
                break;
        }
    }
}
