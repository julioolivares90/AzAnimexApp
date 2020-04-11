package com.darkwizard.azanimexapp.repository

import com.darkwizard.azanimexapp.Api
import com.darkwizard.azanimexapp.models.InicioPost

class AnimesRepository {
    suspend fun GetAnimes() : MutableList<InicioPost>{
        return Api.retrofitInstance.retrofit.getAllAnimes(1)
    }
}