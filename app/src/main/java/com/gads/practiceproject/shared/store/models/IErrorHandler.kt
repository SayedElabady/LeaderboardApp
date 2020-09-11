package com.arabiacell.qayer.shared.store.models

interface IErrorHandler{

    fun getError(throwable: Throwable) : ErrorModel
}