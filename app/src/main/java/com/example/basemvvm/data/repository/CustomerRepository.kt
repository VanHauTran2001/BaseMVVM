package com.example.basemvvm.data.repository

import com.example.basemvvm.di.IoDispatcher
import com.fatherofapps.androidbase.data.services.CustomerLocalService
import com.fatherofapps.androidbase.data.services.CustomerRemoteService

import kotlinx.coroutines.CoroutineDispatcher

class CustomerRepository constructor(
    private val customerRemoteService: CustomerRemoteService,
    private val customerLocalService: CustomerLocalService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
}