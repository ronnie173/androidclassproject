package com.snappyapps.contactmanager.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.adapters.ContactResultsAdapter;
import com.snappyapps.contactmanager.dialogs.AddStudentDialog;
import com.snappyapps.contactmanager.models.Contacts;
import com.snappyapps.contactmanager.presenters.IContactPresenter;
import com.snappyapps.contactmanager.presenters.impl.ContactsPresenter;

import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private IContactPresenter presenter;
    ContactResultsAdapter adapter;
    RealmResults<Contacts> contacts;
    RecyclerView recyclerView;
    private String id;
    private GridLayoutManager gridLayoutManager;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
        presenter = new ContactsPresenter(this);
    //    id = getIntent().getStringExtra(RealmTable.ID);
        initializeRecyclerview();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddContactDialog();
            }
        });
    }
    private void showAddContactDialog() {
        final AddStudentDialog dialog = new AddStudentDialog();
        dialog.show(getSupportFragmentManager(), dialog.getClass().getName());
        dialog.setListener(new AddStudentDialog.OnAddContactsClickListener() {
            @Override
            public void onAddStudentClickListener(Contacts student) {
                dialog.dismiss();
//                presenter.addContactById(student, id);
//                presenter.getAllContactsById(id);
                presenter.addContact(student);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        presenter.subscribeCallbacks();
        //presenter.deleteContactByPosition(0);
        presenter.getAllContacts();

//        presenter.getContactById(id);
//        presenter.getAllContactsById(id);
     //   presenter.deleteContactById(id);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribeCallbacks();
    }

    private void initializeRecyclerview() {
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override

            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                presenter.deleteContactById(contacts.get(viewHolder.getAdapterPosition()).getId());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(recyclerView);


    }

//    public void showContacts(RealmList<Contacts> contacts) {
//        this.contacts = contacts;
//        adapter = new AddContactsAdapter(contacts);
//        recyclerView.setAdapter(adapter);
//    }
public void showResults(RealmResults<Contacts> contactscur) {
    this.contacts = contactscur;
    adapter = new ContactResultsAdapter(contactscur);
//    adapter.setOnItemClickListener(new UniversityAdapter.OnItemClickListener() {
//        @Override
//        public void onItemClick(String id) {
//            Intent intent = new Intent(getApplicationContext(), StudentsActivity.class);
//            intent.putExtra(RealmTable.ID, id);
//            startActivity(intent);
//        }
//    });
    recyclerView.setAdapter(adapter);
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
    public void showMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

}
