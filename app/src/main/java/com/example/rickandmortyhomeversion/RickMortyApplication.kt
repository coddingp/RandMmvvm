package com.example.rickandmortyhomeversion

import android.app.Application
import com.example.rickandmortyhomeversion.common.CommonModule
import com.example.rickandmortyhomeversion.main.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class RickMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@RickMortyApplication)
            modules(
                CommonModule.createRetrofit(),
                MainModule.create()
            )
        }
    }
}