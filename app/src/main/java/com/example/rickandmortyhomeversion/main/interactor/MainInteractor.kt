package com.example.rickandmortyhomeversion.main.interactor

import com.example.rickandmortyhomeversion.main.repository.MainRemoteRepository

class MainInteractor (
    private val remoteRepository: MainRemoteRepository
){
    suspend fun getResults() = remoteRepository.getResult()
}