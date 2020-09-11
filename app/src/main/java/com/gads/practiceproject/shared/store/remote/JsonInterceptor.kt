package com.beat.androidtask.foddvenues.shared.store.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class JsonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var modifiedRequest = request
        modifiedRequest = modifiedRequest.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(modifiedRequest)
    }

}