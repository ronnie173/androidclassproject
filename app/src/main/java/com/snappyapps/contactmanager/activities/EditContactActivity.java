package com.snappyapps.contactmanager.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.models.Contacts;
import com.snappyapps.contactmanager.realm.RealmTable;

import io.realm.Realm;

/**
 * Created by jeromeraymond on 4/11/16.
 */
/**
 * EditContactActivity
 * This class is the activity that edits a contact
 */

public class EditContactActivity extends AppCompatActivity implements View.OnClickListener {

    Button editContactBtn;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    Contacts contact;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeComponents();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            contact = getContact(extras.getString("id"));
            emailEditText.setText(contact.getEmailAddress());
            nameEditText.setText(contact.getName());
            phoneEditText.setText(contact.getPhoneNumber());
            addressEditText.setText(contact.getAddress());

        }
    }

    /**
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editContactBtn:
                updateContact(realm, contact);
                Toast.makeText(EditContactActivity.this, "Edited Contact Named " + contact.getName(), Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
    }

    /**
     * Initializes all of the gui components ans sets listeners
     */
    private void initializeComponents() {
        editContactBtn = (Button) findViewById(R.id.editContactBtn);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        realm = Realm.getDefaultInstance();
        editContactBtn.setOnClickListener(this);
    }

    /**
     * Gets the contact from the realm database and returns a contact that was first
     * @param id
     * @return
     */
    private Contacts getContact(String id) {

        realm.beginTransaction();
        Contacts contact = realm.where(Contacts.class).equalTo(RealmTable.ID, id).findFirst();
        realm.commitTransaction();

        return contact;
    }

    /**
     * This updates a contact in the realm database.
     * @param realm
     * @param contact
     */
    public void updateContact(Realm realm, Contacts contact) {
        Contacts toEdit = realm.where(Contacts.class)
                .equalTo(RealmTable.ID, contact.getId()).findFirst();
        realm.beginTransaction();
        toEdit.setEmailAddress(emailEditText.getText().toString());
        toEdit.setName(nameEditText.getText().toString());
        toEdit.setPhoneNumber(phoneEditText.getText().toString());
        toEdit.setAddress(addressEditText.getText().toString());
        realm.commitTransaction();
    }

}
