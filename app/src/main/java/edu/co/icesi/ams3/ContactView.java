package edu.co.icesi.ams3;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContactView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Contact contact;

    private ConstraintLayout root;
    private TextView nombre;
    private TextView telefono;
    private Button contactcall;
    private Button contactdelete;

    private OnContactItemAction listener;

    public ContactView(ConstraintLayout root) {
        super(root);
        nombre = root.findViewById(R.id.contactname);
        telefono = root.findViewById(R.id.contactphone);
        contactcall = root.findViewById(R.id.contactcall);
        contactdelete = root.findViewById(R.id.contactdelete);

        contactdelete.setOnClickListener(this);
        contactcall.setOnClickListener(this);
    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getTelefono() {
        return telefono;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.contactdelete:
                if(listener!=null) listener.onDeleteContact(this.contact);
                break;
            case R.id.contactcall:

                break;

        }
    }

    public void setListener(OnContactItemAction listener){
        this.listener = listener;
    }

    public interface OnContactItemAction{
        void onDeleteContact(Contact contact);
    }

    public void setContact(Contact contact){
        this.contact = contact;
    }
}
