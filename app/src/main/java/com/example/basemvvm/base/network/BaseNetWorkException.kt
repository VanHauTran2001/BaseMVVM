package com.example.basemvvm.base.network

class BaseNetWorkException( val responseMessage: String? = null, val responseCode: Int = -1) :Exception(){

    var mainMessage = ""

    fun parseFromString(errorBody: String) {

    }
}