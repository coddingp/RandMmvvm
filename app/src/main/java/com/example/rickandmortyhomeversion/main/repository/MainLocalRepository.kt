package com.example.rickandmortyhomeversion.main.repository

import com.example.rickandmortyhomeversion.main.db.dao.DataDao
import com.example.rickandmortyhomeversion.main.db.model.EntityConverter
import com.example.rickandmortyhomeversion.main.models.ResultParced
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainLocalRepository(val dao: DataDao) : LocalRepository {
    override suspend fun getDataFromDb():
            Flow<List<ResultParced>> {
        val data = dao.getAllData()
        return data.map { EntityConverter.fromDataBase(it)}
    }

    override suspend fun insertAllDataToDb(list: List<ResultParced>) {
        val data = EntityConverter.toDataBase(list)
        dao.insetAllData(data)
    }

}