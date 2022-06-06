package com.example.rickandmortyhomeversion.main.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.common.mvvm.BaseActivity
import com.example.rickandmortyhomeversion.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("!MainActivity", "activity created")
        Timber.tag("!MainActivity").i("activity created")
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        }
        val characterListFragment = CharacterListFragment()
        changeFragment(characterListFragment, R.id.fragmentContainer)
    }
}