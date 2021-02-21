package edu.co.icesi.ams3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactView> implements ContactView.OnContactItemAction{

    private ArrayList<Contact> contacts;

    public void addContact(Contact contact){
        contacts.add(contact);
        notifyDataSetChanged();
    }

    public ContactsAdapter(){
        contacts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ContactView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.contactrow, parent, false);
        ConstraintLayout rowroot = (ConstraintLayout) view;
        ContactView contactView = new ContactView(rowroot);
        contactView.setListener(this);
        return contactView;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactView holder, int position) {
        holder.setContact(contacts.get(position));
        holder.getNombre().setText(contacts.get(position).getNombre());
        holder.getTelefono().setText(contacts.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    @Override
    public void onDeleteContact(Contact contact) {
        contacts.remove(contact);
        this.notifyDataSetChanged();
    }
}
