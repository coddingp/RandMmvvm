package com.example.rickandmortyhomeversion.main.api

import com.example.rickandmortyhomeversion.main.api.model.CharacterDataResponse
import retrofit2.http.GET

interface InterfaceApi {
    @GET("character")
    suspend fun getResults(): CharacterDataResponse
}