package com.snappyapps.contactmanager.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.models.Contacts;

import io.realm.RealmResults;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public class ContactResultsAdapter extends RecyclerView.Adapter<ContactResultsAdapter.ContactResultsViewHolder> {
    private OnItemClickListener onItemClickListener;
    private RealmResults<Contacts> contacts;

    /**
     * Instantiates a new Contact results adapter.
     *
     * @param contacts the contacts
     */
    public ContactResultsAdapter(RealmResults<Contacts> contacts) {
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


    /**
     * The type Contact results view holder.
     */
    public class ContactResultsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * The User name.
         */
        public TextView userName;
        /**
         * The User photo.
         */
        public ImageView userPhoto;

        /**
         * Instantiates a new Contact results view holder.
         *
         * @param itemView the item view
         */
        public ContactResultsViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            userName = (TextView) itemView.findViewById(R.id.userName);
            userPhoto = (ImageView) itemView.findViewById(R.id.userPhoto);

        }

        @Override
        public void onClick(View view) {
            Contacts currentContacts = contacts.get(getAdapterPosition());
            onItemClickListener.onItemClick(currentContacts.getId());
        }
    }

    /**
     * The interface On item click listener.
     */
    public interface OnItemClickListener {
        /**
         * On item click.
         *
         * @param id the id
         */
        void onItemClick(String id);
    }

    /**
     * Sets on item click listener.
     *
     * @param onItemClickListener the on item click listener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
