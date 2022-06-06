package com.example.rickandmortyhomeversion.main.repository

import com.example.rickandmortyhomeversion.main.models.ResultParced

interface MainRepository {
    suspend fun getResult():List<ResultParced>
}