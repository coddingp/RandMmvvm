package com.example.rickandmortyhomeversion.main.di

import androidx.room.Room
import com.example.rickandmortyhomeversion.main.db.database.AppDataBase
import com.example.rickandmortyhomeversion.main.interactor.Interactor
import com.example.rickandmortyhomeversion.main.repository.LocalRepository
import com.example.rickandmortyhomeversion.main.repository.MainLocalRepository
import com.example.rickandmortyhomeversion.main.repository.MainRemoteRepository
import com.example.rickandmortyhomeversion.main.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create(): Module = module {
        single {
            Room.databaseBuilder(get(), AppDataBase::class.java, "Characters_data")
                .build()
        }
        factory {
            val interactor = Interactor(get(), get())
            interactor
        } bind Interactor::class
        single { get<AppDataBase>().heroesDao() }
        single<LocalRepository> { MainLocalRepository(get()) }
        single<MainRemoteRepository> { MainRemoteRepository(get()) }
        viewModel { MainViewModel(get()) }
    }
}