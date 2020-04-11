package com.darkwizard.azanimexapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darkwizard.azanimexapp.models.InicioPost
import com.darkwizard.azanimexapp.repository.AnimesRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class InicioViewModel : ViewModel {

   constructor(){
       SetAnimes()
   }
    val animesRepository = AnimesRepository()
    private  var _animesList = MutableLiveData<MutableList<InicioPost>>()

    public fun GetAnimeList() : LiveData<MutableList<InicioPost>> = _animesList

    private fun SetAnimes() {
        viewModelScope.launch {
            _animesList.value = animesRepository.GetAnimes()
        }
    }
}