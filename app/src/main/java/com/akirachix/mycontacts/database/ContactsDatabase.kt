package com.akirachix.mycontacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akirachix.mycontacts.model.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class ContactsDatabase: RoomDatabase() {

    abstract fun getContactDao(): ContactDao

    companion object{
        private var database: ContactsDatabase? = null

        fun getDatabase(context: Context): ContactsDatabase{
//            no instance created yet
            if(database==null){
                database = Room
                    .databaseBuilder(context, ContactsDatabase::class.java, "contacts_db")
                    .build()
            }

//            creates a new database
//            activity context, global application context
            return database as ContactsDatabase

        }
    }


}