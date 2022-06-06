package com.example.rickandmortyhomeversion.main.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyhomeversion.main.db.dao.DataDao
import com.example.rickandmortyhomeversion.main.db.model.EntityData

@Database(entities = [EntityData::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun heroesDao(): DataDao
}
