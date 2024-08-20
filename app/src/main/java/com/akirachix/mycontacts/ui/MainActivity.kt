package com.akirachix.mycontacts.ui

import ContactsAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akirachix.mycontacts.databinding.ActivityMainBinding
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()

        binding.fabAddContact.setOnClickListener{
            startActivity(Intent(this, AddContactActivity::class.java))
        }
        contactsViewModel.getAllContacts().observe(this){contactsList ->
            displayContacts(contactsList)
        }
    }

    fun displayContacts(contactsList: List<Contact>){
        val contactsAdapter = ContactsAdapter(contactsList, this)
        binding.rvContacts.adapter = contactsAdapter
//        val contact1 = Contact("Tina", "0712345677", "tina@gmail.com", "")
//        val contact2 = Contact("John", "0712345678", "john@gmail.com", "")
//        val contact3 = Contact("Wangesha", "0712345676", "wangesha@gmail.com", "")
//        val contact4 = Contact("Waluse", "0712345675", "waluse@gmail.com", "")
//        val contact5 = Contact("Hannah", "0712345674", "hannah@gmail.com", "")
//        val contact6 = Contact("Queen", "0712345673", "queen@gmail.com", "")
//        val contact7 = Contact("Chep", "0712345672", "chep@gmail.com", "")

//        val contactsList = listOf(contact1,contact2,contact3,contact4,contact5,contact6,contact7)
//        val contactsAdapter = ContactsAdapter(contactsList)
//        binding.rvContacts.adapter = contactsAdapter
    }
}