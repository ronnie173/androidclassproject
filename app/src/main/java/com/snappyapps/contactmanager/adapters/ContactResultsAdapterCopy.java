package com.snappyapps.contactmanager.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.models.Contacts;

import io.realm.RealmResults;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public class ContactResultsAdapterCopy extends RecyclerView.Adapter<ContactResultsAdapterCopy.ContactResultsViewHolder> {
    private OnItemClickListener onItemClickListener;
    private RealmResults<Contacts> contacts;

    public ContactResultsAdapterCopy(RealmResults<Contacts> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactResultsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ContactResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactResultsViewHolder holder, int position) {
        holder.userName.setText(contacts.get(position).getName());
        holder.userPhoto.setImageResource(R.mipmap.pic1);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public class ContactResultsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView userName;
        public TextView userAddress;
        public TextView userEmailAddress;
        public TextView userPhoneNumber;
        public ImageView userPhoto;

        public ContactResultsViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            userName = (TextView) itemView.findViewById(R.id.userName);
            userPhoto = (ImageView) itemView.findViewById(R.id.userPhoto);
            userAddress = (EditText) itemView.findViewById(R.id.addressEditText);
            userEmailAddress = (EditText)itemView.findViewById(R.id.emailEditText);
            userPhoneNumber = (EditText)itemView.findViewById(R.id.phoneEditText);
        }

        @Override
        public void onClick(View view) {
            Contacts currentContacts = contacts.get(getAdapterPosition());
            onItemClickListener.onItemClick(currentContacts.getId());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String id);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
