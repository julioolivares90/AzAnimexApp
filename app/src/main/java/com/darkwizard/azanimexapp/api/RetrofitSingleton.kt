package com.darkwizard.azanimexapp.api

import com.darkwizard.azanimexapp.constantes.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    fun createService() : Api{
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
            BASE_URL).build()
        return  retrofit.create(Api::class.java)
    }
}