package com.akirachix.mycontacts.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityViewContactBinding
import com.akirachix.mycontacts.databinding.ContactListItemBinding
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.viewmodel.ContactsViewModel

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    var contactId = 0
    lateinit var myContact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.extras!= null){
            contactId = intent.getIntExtra("CONTACT_ID", 0)
        }
        else{
            finish()
        }
        }

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            myContact.avatar = uri.path.toString()
            contactsViewModel.updateContact(myContact)
//         Toast.makeText(this, uri.toString(), Toast.LENGTH_LONG).show()
        }
    }

        override fun onResume() {
            super.onResume()
            contactsViewModel.getContactById(contactId).observe(this){contact ->
                myContact = contact
                binding.tvContactName.text = contact.name
                binding.tvContactPhoneNumber.text = contact.phoneNumber
                binding.tvContactEmail.text = contact.email

        }

            binding.ivContactImage.setOnClickListener{
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
    }
}