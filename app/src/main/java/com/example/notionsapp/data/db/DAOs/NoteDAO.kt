package com.example.notionsapp.data.db.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notionsapp.data.models.NoteModel

@Dao
interface NoteDAO  {
    @Query("SELECT * FROM noteModels")
    fun getAll(): LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModel: NoteModel)
}