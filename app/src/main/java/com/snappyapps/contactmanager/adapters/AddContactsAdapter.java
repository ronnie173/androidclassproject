package com.snappyapps.contactmanager.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.models.Contacts;

import io.realm.RealmList;

public class AddContactsAdapter extends RecyclerView.Adapter<AddContactsViewHolder> {

    private RealmList<Contacts> contacts;


    public AddContactsAdapter(RealmList<Contacts> contacts) {
        this.contacts = contacts;

    }

    @Override
    public AddContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, null);
        AddContactsViewHolder rcv = new AddContactsViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(AddContactsViewHolder holder, int position) {
        holder.userName.setText(contacts.get(position).getName());
        holder.userPhoto.setImageResource(R.mipmap.pic1);
    }

    @Override
    public int getItemCount() {
        return this.contacts.size();
    }
}
