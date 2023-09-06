package com.open6.taleadventure.data.remote.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.open6.taleadventure.BuildConfig
import com.open6.taleadventure.data.remote.interceptor.TokenInterceptor
import com.open6.taleadventure.data.remote.service.HomeService
import com.open6.taleadventure.data.remote.service.LoginService
import com.open6.taleadventure.data.remote.service.SetUserInfoService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private val json by lazy {
        Json {
            coerceInputValues = true
        }
    }
    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(TokenInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }).build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType())).build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)

    object ServicePool {
        val loginService = create<LoginService>()
        val setUserInfoService = create<SetUserInfoService>()
        val homeService = create<HomeService>()
    }
}