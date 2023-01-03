package com.example.basemvvm.base.network

open class NetworkErrorException(val responseMessage : String ?= null) : Exception() {
}