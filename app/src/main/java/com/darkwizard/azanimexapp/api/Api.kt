package com.darkwizard.azanimexapp.api

import com.darkwizard.azanimexapp.models.InicioPost
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("posts/page/{numberPage}")
   suspend fun getAllAnimes(@Path("numberPage") numberPage : Int) : MutableList<InicioPost>
}