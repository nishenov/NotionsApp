package com.example.notionsapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "noteModels")
data class NoteModel(
    var header: String,
    var description: String,
    var date: String,
    var textColor: Int,
    var backgroundColor: Int) : Serializable
{
        @PrimaryKey(autoGenerate = true)
        var id : Int = 0
    }
