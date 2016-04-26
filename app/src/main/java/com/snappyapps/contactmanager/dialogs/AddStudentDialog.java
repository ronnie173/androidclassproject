package com.snappyapps.contactmanager.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.snappyapps.contactmanager.R;
import com.snappyapps.contactmanager.models.Contacts;

/**
 * Created by jeromeraymond on 4/25/16.
 */
public class AddStudentDialog extends DialogFragment implements View.OnClickListener {
    private Button addNewContactBtn;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    private ImageView photo;

    private OnAddContactsClickListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AlertDialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_new_contact, container,true);
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View view) {
        addNewContactBtn = (Button) view.findViewById(R.id.addNewContactBtn);
        nameEditText = (EditText) view.findViewById(R.id.nameEditText);
        emailEditText = (EditText) view.findViewById(R.id.emailEditText);
        phoneEditText = (EditText) view.findViewById(R.id.phoneEditText);
        addressEditText = (EditText) view.findViewById(R.id.addressEditText);
        addNewContactBtn.setOnClickListener(this);
    }

    private boolean isUserInfoValidate() {
        return !nameEditText.getText().toString().isEmpty() &&
                !emailEditText.getText().toString().isEmpty() &&
                !phoneEditText.getText().toString().isEmpty() &&
                !addressEditText.getText().toString().isEmpty();
    }

    public void setListener(OnAddContactsClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addNewContactBtn:{
                if (isUserInfoValidate()){
                    Contacts contacts = new Contacts();
                    contacts.setName(nameEditText.getText().toString());
                    contacts.setEmailAddress(emailEditText.getText().toString());
                    contacts.setPhoneNumber(phoneEditText.getText().toString());
                    contacts.setAddress(addressEditText.getText().toString());
                    listener.onAddStudentClickListener(contacts);
                }
            }
            break;
        }
    }

    public interface OnAddContactsClickListener {
        void onAddStudentClickListener(Contacts student);
    }
}
