package com.example.rickandmortyhomeversion.main.interactor

import com.example.rickandmortyhomeversion.main.models.ResultParced
import com.example.rickandmortyhomeversion.main.repository.LocalRepository
import com.example.rickandmortyhomeversion.main.repository.MainRemoteRepository
import kotlinx.coroutines.flow.Flow

class Interactor(
    val remoteRepository: MainRemoteRepository,
    val localRepository: LocalRepository
) {
    suspend fun getDataFromDb(): Flow<List<ResultParced>> =
        localRepository.getDataFromDb()

    suspend fun uploadHeroes(){
        val data = remoteRepository.getResult()
        localRepository.insertAllDataToDb(data)
    }
}