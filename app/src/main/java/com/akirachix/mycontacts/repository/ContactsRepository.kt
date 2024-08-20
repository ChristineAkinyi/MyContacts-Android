package com.akirachix.mycontacts.repository

import androidx.lifecycle.LiveData
import com.akirachix.mycontacts.model.ContactsApp
import com.akirachix.mycontacts.database.ContactsDatabase
import com.akirachix.mycontacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDatabase.getDatabase(ContactsApp.appContext)

   suspend fun saveContact(contact: Contact){
       withContext(Dispatchers.IO){
           database.getContactDao().insertContact(contact)
       }
   }
    fun getAllContacts():LiveData<List<Contact>>{
        return database.getContactDao().getAllContacts()
    }
}