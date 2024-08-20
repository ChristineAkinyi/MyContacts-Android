package com.akirachix.mycontacts.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.akirachix.mycontacts.databinding.ActivityAddContactBinding
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.viewmodel.ContactsViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener { validateContact() }
    }

    fun validateContact(){
        val name = binding.etName.text.toString()
        val phone = binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if(name.isBlank()){
            error = true
            binding.etName.error = (name)
        }

        if(phone.isBlank()){
            error = true
            binding.etPhone.error = (phone)
        }

        if(email.isBlank()){
            error = true
            binding.etEmail.error = (email)
        }

        if (!error){
            val newContact = Contact(contactId = 0, name= name, email= email, phoneNumber = phone, avatar = "" )
            contactsViewModel.saveContact(newContact)
            finish()
        }
    }
}


