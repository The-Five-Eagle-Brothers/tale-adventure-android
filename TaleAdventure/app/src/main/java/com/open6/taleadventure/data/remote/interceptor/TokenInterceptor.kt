package com.open6.taleadventure.data.remote.interceptor

import com.open6.taleadventure.data.local.TaleAdventureSharedPreferences
import com.open6.taleadventure.data.remote.DataPublicString.ACCESS_TOKEN
import com.open6.taleadventure.data.remote.DataPublicString.AUTHORIZATION
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val userToken = TaleAdventureSharedPreferences.getString(ACCESS_TOKEN)

        if (userToken.isNullOrBlank()) {
            return chain.proceed(originalRequest)
        }

        val tokenAddedRequest = originalRequest.newBuilder().header(
            AUTHORIZATION, userToken
        ).build()

        return chain.proceed(tokenAddedRequest)
    }
}