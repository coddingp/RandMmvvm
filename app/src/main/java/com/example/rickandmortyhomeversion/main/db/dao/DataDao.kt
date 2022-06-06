package com.example.rickandmortyhomeversion.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyhomeversion.main.db.model.EntityData
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {
    @Insert(entity = EntityData::class, onConflict = OnConflictStrategy.IGNORE)
    fun insetAllData(data: List<EntityData>)

    @Query("SELECT* FROM characters_data")
    fun getAllData(): Flow<List<EntityData>>

}