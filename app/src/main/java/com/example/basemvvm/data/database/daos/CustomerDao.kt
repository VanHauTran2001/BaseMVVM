package com.example.basemvvm.data.database.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.basemvvm.data.database.entities.CustomerEntity

@Dao
interface CustomerDao {

    @Query("select * from customer")
    fun getAll(): List<CustomerEntity>

}