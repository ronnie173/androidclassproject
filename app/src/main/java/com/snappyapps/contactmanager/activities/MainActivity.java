package com.snappyapps.contactmanager.activities;

import android.annotation.TargetApi;
import android.content.Intent;
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
import com.snappyapps.contactmanager.realm.RealmTable;

import io.realm.RealmResults;
/**
 * Created by jeromeraymond on 4/11/16.
 */
/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private IContactPresenter presenter;
    /**
     * The Adapter.
     */
    ContactResultsAdapter adapter;
    /**
     * The Contacts.
     */
    RealmResults<Contacts> contacts;
    /**
     * The Recycler view.
     */
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
        initializeRecyclerview();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddContactDialog();
            }
        });
    }

    /**
     * This shows the add contact dialog
     */
    private void showAddContactDialog() {
        final AddStudentDialog dialog = new AddStudentDialog();
        dialog.show(getSupportFragmentManager(), dialog.getClass().getName());
        dialog.setListener(new AddStudentDialog.OnAddContactsClickListener() {
            @Override
            public void onAddStudentClickListener(Contacts student) {
                dialog.dismiss();
                presenter.addContact(student);
            }
        });
    }

    /**
     * This gets all of the contacts to load
     * when the application starts or when the view is started
     */
    @Override
    protected void onStart() {
        super.onStart();
        presenter.subscribeCallbacks();
        presenter.getAllContacts();

    }

    /**
     * This unsubscribes all callbacks
     */
    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribeCallbacks();
    }

    /**
     * Initialize the recyclerview and swipe to delete
     */
    private void initializeRecyclerview() {
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        /**
         * ItemTouchHelper to remove contact on swipe left or right
         */
        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override

            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(MainActivity.this, "You deleted " + contacts.get(viewHolder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                presenter.deleteContactById(contacts.get(viewHolder.getAdapterPosition()).getId());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(recyclerView);


    }

    /**
     * Shows the results using realmresults
     *
     * @param contactscur the contactscur
     */
    public void showResults(RealmResults<Contacts> contactscur) {
        this.contacts = contactscur;
        adapter = new ContactResultsAdapter(contactscur);
        adapter.setOnItemClickListener(new ContactResultsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String id) {
                Intent intent = new Intent(getApplicationContext(), ShowContactActivity.class);
                intent.putExtra(RealmTable.ID, id);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
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

    /**
     * Helper to show toasts
     *
     * @param message the message
     */
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

}
