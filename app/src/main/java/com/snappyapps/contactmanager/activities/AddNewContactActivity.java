package com.snappyapps.contactmanager.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.snappyapps.contactmanager.ApplicationHelper;
import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.db.DatabaseHelper;

public class AddNewContactActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addNewContactBtn;
    private EditText nameEditText;
    private EditText emaiEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    private ImageView photo;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        android.widget.Toolbar toolbar = (android.widget.Toolbar) findViewById(R.id.toolbar2);
        setActionBar(toolbar);
        initializeComponents();
        addNewContactBtn.setOnClickListener(this);
    }

    private void initializeComponents() {
        addNewContactBtn = (Button) findViewById(R.id.addNewContactBtn);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emaiEditText = (EditText) findViewById(R.id.emailEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addNewContactBtn:
                DatabaseHelper databaseHelper = new DatabaseHelper(ApplicationHelper.getDatabaseInstance(), view.getContext());
                databaseHelper.insertData(nameEditText.getText().toString(),
                        addressEditText.getText().toString(),
                        emaiEditText.getText().toString(),
                        phoneEditText.getText().toString());
                break;

        }
    }
}
