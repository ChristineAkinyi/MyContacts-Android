package com.akirachix.mycontacts.repository

import android.adservices.adid.AdId
import androidx.lifecycle.LiveData
import com.akirachix.mycontacts.ContactsApp
import com.akirachix.mycontacts.database.ContactsDatabase
import com.akirachix.mycontacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDatabase.getDatabase(ContactsApp.appContext)
    val contactDao = database.getContactDao()

   suspend fun saveContact(contact: Contact){
       withContext(Dispatchers.IO){
           contactDao.insertContact(contact)
       }
   }
    fun getAllContacts():LiveData<List<Contact>>{
        return contactDao.getAllContacts()
    }

    fun getContactById(contactId: Int): LiveData<Contact>{
        return contactDao.getContactById(contactId)
    }

    suspend fun updateContact(contact: Contact){
        withContext(Dispatchers.IO){
            database.getContactDao().updateContact(contact)
        }
    }
}