package com.example.rickandmortyhomeversion.main.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyhomeversion.main.interactor.Interactor
import com.example.rickandmortyhomeversion.main.models.ResultParced
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    private val interactor: Interactor
) : ViewModel() {
    val listLiveData = MutableLiveData<List<ResultParced>>()

    init {
        viewModelScope.launch {
            interactor.getDataFromDb().collect { list ->
                Timber.tag("###").i("$list")
                listLiveData.value = list
            }
        }
    }

    fun loadRickMorty() = viewModelScope.launch {
        try {
            interactor.uploadHeroes()
        } catch (throwable: Throwable) {
            Timber.tag("###").e(throwable, "Error process in loadDataHeroes() ")
        }
    }
}