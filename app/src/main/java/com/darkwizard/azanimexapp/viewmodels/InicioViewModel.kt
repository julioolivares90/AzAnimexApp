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

class InicioViewModel : ViewModel() {

    val animesRepository = AnimesRepository()

    private val _animesList : MutableLiveData<MutableList<InicioPost>> by lazy {
        MutableLiveData<MutableList<InicioPost>>().also {
            SetAnimes()
        }
    }

    private   val _isLoading : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().also {
            it.value = true
        }
    }

    public fun  IsLoading() : LiveData<Boolean> = _isLoading

    private fun SetLoading(isLoading : Boolean) {
        _isLoading.value = isLoading
    }


    public fun GetAnimeList() : LiveData<MutableList<InicioPost>> = _animesList

    private fun SetAnimes() {
        viewModelScope.launch {
            SetLoading(true)
            _animesList.value = animesRepository.GetAnimes()
            SetLoading(false)
        }
    }
}