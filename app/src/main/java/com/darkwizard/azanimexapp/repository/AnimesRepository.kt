package com.darkwizard.azanimexapp.repository

import com.darkwizard.azanimexapp.api.Api
import com.darkwizard.azanimexapp.api.RetrofitSingleton
import com.darkwizard.azanimexapp.models.InicioPost

class AnimesRepository {
    suspend fun GetAnimes() : MutableList<InicioPost>{
        val retrofitSingleton = RetrofitSingleton.createService()
        return retrofitSingleton.getAllAnimes(1)
    }
}