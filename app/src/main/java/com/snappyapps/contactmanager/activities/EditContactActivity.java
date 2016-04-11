package com.snappyapps.contactmanager.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.snappyapps.contactmanager.R;

public class EditContactActivity extends AppCompatActivity implements View.OnClickListener{

    Button addNewContactBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addNewContactBtn = (Button)findViewById(R.id.addNewContactBtn);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.addNewContactBtn:
                Toast.makeText(EditContactActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
