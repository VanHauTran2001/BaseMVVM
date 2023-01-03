package com.example.basemvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basemvvm.data.database.daos.CustomerDao
import com.example.basemvvm.data.database.entities.CustomerEntity

@Database(entities = [CustomerEntity::class],version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun customerDao() : CustomerDao
}