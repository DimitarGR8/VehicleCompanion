package com.vehiclecompanion.remote.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .apply {
                    addHeader("Accept", "application/json")
                    addHeader("Content-Type", "application/json")
                }.build()
        )
    }
}
