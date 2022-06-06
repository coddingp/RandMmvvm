package com.example.rickandmortyhomeversion.main.repository

import com.example.rickandmortyhomeversion.main.models.ResultParced
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun getDataFromDb(): Flow<List<ResultParced>>
    suspend fun insertAllDataToDb(list: List<ResultParced>)
}