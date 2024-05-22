package com.example.notionsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notionsapp.data.db.DAOs.NoteDAO
import com.example.notionsapp.data.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao():NoteDAO
}