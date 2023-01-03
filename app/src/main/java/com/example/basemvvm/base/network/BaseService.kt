package com.example.basemvvm.base.network

abstract class BaseService {

    protected fun parseError(
        responseMessage : String?,
        responseCode : Int,
        errorBody : String?
    ) : BaseNetWorkException{
        val baseNetWorkException = BaseNetWorkException(responseMessage,responseCode)
        errorBody?.let {
            baseNetWorkException.parseFromString(it)
        }
        return baseNetWorkException
    }

    protected fun parseNetworkErrorException(throwable: Throwable) : NetworkErrorException{
        return NetworkErrorException(throwable.message)
    }
}