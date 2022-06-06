package com.example.rickandmortyhomeversion.main.models

import com.example.rickandmortyhomeversion.main.api.model.CharacterDataResponse
import com.example.rickandmortyhomeversion.main.api.model.LocationResponse
import com.example.rickandmortyhomeversion.main.api.model.OriginResponse

object MainConverter {

    fun fromNetWork(response: CharacterDataResponse): List<ResultParced> {
        return response.results!!.map { result ->
            ResultParced(
                id = result.id,
                name = result.name,
                status = result.status,
                species = result.species,
                type = result.type,
                gender = result.gender,
                image = result.image,
                url = result.url,
                created = result.created
            )
        }
    }

    private fun fromNetworkOrigin(response: OriginResponse) =
        Origin(
            name = response.name,
            url = response.url
        )

    private fun fromNetworkLocation(response: LocationResponse) =
        Location(
            name = response.name,
            url = response.url
        )
}