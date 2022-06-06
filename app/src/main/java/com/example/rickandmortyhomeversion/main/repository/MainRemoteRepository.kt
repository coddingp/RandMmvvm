package com.example.rickandmortyhomeversion.main.repository

import android.util.Log
import com.example.rickandmortyhomeversion.main.api.InterfaceApi
import com.example.rickandmortyhomeversion.main.models.MainConverter
import com.example.rickandmortyhomeversion.main.models.ResultParced

class MainRemoteRepository(
    private val api: InterfaceApi
) : MainRepository {
    override suspend fun getResult(): List<ResultParced> {
        val data = api.getResults()
        Log.i("$%$", "Remote dat: $data")
        return MainConverter.fromNetWork(data)
    }

}