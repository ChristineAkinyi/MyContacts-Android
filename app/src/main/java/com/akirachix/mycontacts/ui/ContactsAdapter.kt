package com.akirachix.mycontacts.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.databinding.ContactListItemBinding

class ContactsAdapter(val contactsList: List<Contact>):RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ContactsViewHolder {
        val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//       var itemView = LayoutInflater.from(rvContact.context)
//           .inflate(R.layout.contact_list_item, rvContact, false)
        return ContactsViewHolder(binding)
    }
    
    override fun getItemCount(): Int {
          return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
            val contact = contactsList[position]
        holder.binding.tvName.text = contact.name
        holder.binding.tvEmail.text = contact.email
        holder.binding.tvPhoneNumber.text = contact.phoneNumber
    }
}

class ContactsViewHolder( var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){
//    var cvContact = itemView.findViewById<MaterialCardView>(R.id.cvContact)
//    var tvName =itemView.findViewById<TextView>(R.id.tvName)
//    var tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
//    var tvPhoneNumber = itemView.findViewById<TextView>(R.id.tvPhoneNumber)
}