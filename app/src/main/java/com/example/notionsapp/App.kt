package com.example.notionsapp

import android.app.Application
import androidx.room.Room
import com.example.notionsapp.data.db.AppDatabase
import com.example.notionsapp.util.PreferenceHelper

class App : Application() {
    companion object{
        var appDatabase: AppDatabase? = null
    }
    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
        getInstance()
    }

    fun getInstance(): AppDatabase? {
        if (appDatabase == null){
            appDatabase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDatabase
    }
}