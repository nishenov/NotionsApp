package com.example.notionsapp

import android.app.Application
import com.example.notionsapp.util.PreferenceHelper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
    }
}