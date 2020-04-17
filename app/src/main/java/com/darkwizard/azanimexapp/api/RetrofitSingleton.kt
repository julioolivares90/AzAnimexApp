package com.darkwizard.azanimexapp.api

import com.darkwizard.azanimexapp.constantes.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitSingleton {

    private val okHttp = OkHttpClient.Builder()
        .connectTimeout(3000,TimeUnit.MILLISECONDS)
        .readTimeout(3000,TimeUnit.MILLISECONDS)

    private val builder = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory
        .create()).client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>) : T {
        return retrofit.create(serviceType)
    }
}