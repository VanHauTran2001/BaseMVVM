package com.fatherofapps.androidbase.data.services

import com.example.basemvvm.data.database.daos.CustomerDao
import javax.inject.Inject

class CustomerLocalService @Inject constructor(private val customerDao: CustomerDao) {
}