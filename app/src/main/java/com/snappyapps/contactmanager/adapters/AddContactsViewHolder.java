package com.snappyapps.contactmanager.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.activities.ShowContactActivity;

public class AddContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView userName;
    public TextView userAddress;
    public TextView UserEmailAddress;
    public TextView userPhoneNumber;
    public ImageView userPhoto;

    public AddContactsViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        userName = (TextView) itemView.findViewById(R.id.userName);
        userPhoto = (ImageView) itemView.findViewById(R.id.userPhoto);


    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(view.getContext(), ShowContactActivity.class);
        view.getContext().startActivity(intent);
    }
}