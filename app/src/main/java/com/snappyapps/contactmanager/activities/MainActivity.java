package com.snappyapps.contactmanager.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.RecyclerViewAdapter;
import com.snappyapps.contactmanager.models.ContactItems;
import com.snappyapps.contactmanager.models.Contacts;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private Realm database;
    RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        database = Realm.getInstance(new RealmConfiguration.Builder(this)
                .name("database.realm")
                .build());

        initializeRecyclerview();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initializeRecyclerview() {
        List<ContactItems> rowListItem = getAllItemList();
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        recyclerView.setAdapter(rvAdapter);
    }

    private void insertData(String name, String address, String emailAddress, String image) {
        database.beginTransaction();
        //create an object
        Contacts contacts = database.createObject(Contacts.class);
        //set the fields
        contacts.setName(name);
        contacts.setAddress(address);
        contacts.setEmailAddress(emailAddress);
        contacts.setImage(image);
        database.commitTransaction();
        Toast.makeText(MainActivity.this, "Object inserted successfully", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ContactItems> getAllItemList() {

        List<ContactItems> allItems = new ArrayList<>();
        allItems.add(new ContactItems("United States", R.mipmap.pic1));
        allItems.add(new ContactItems("Canada", R.mipmap.pic1));
        allItems.add(new ContactItems("United Kingdom", R.mipmap.pic1));
        allItems.add(new ContactItems("Germany", R.mipmap.pic1));
        allItems.add(new ContactItems("Sweden", R.mipmap.pic1));
        allItems.add(new ContactItems("United Kingdom", R.mipmap.pic1));
        allItems.add(new ContactItems("Germany", R.mipmap.pic1));
        allItems.add(new ContactItems("Sweden", R.mipmap.pic1));
        allItems.add(new ContactItems("United States", R.mipmap.pic1));
        allItems.add(new ContactItems("Canada", R.mipmap.pic1));
        allItems.add(new ContactItems("United Kingdom", R.mipmap.pic1));
        allItems.add(new ContactItems("Germany", R.mipmap.pic1));
        allItems.add(new ContactItems("Sweden", R.mipmap.pic1));
        allItems.add(new ContactItems("United Kingdom", R.mipmap.pic1));
        allItems.add(new ContactItems("Germany", R.mipmap.pic1));
        allItems.add(new ContactItems("Sweden", R.mipmap.pic1));

        return allItems;
    }
}
