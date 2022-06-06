package com.example.rickandmortyhomeversion.main.db.model

import com.example.rickandmortyhomeversion.main.models.ResultParced

object EntityConverter {
    fun toDataBase(response: List<ResultParced>): List<EntityData> =
        response.map {
            EntityData(
                ChId = it.id,
                name = it.name,
                gender = it.gender,
                status = it.status,
                species = it.species,
                type = it.type,
                image = it.image,
                url = it.url,
                created = it.created
            )
        }

    fun fromDataBase(response: List<EntityData>): List<ResultParced> {
        val data =
            response.map {
                ResultParced(
                    id = it.ChId,
                    name = it.name,
                    gender = it.gender,
                    status = it.status,
                    species = it.species,
                    type = it.type,
                    image = it.image,
                    url = it.url,
                    created = it.created,
                )
            }
        return data
    }

}