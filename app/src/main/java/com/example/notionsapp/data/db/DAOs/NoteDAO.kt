package com.example.notionsapp.data.db.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notionsapp.data.models.NoteModel

@Dao
interface NoteDAO  {
    @Query("SELECT * FROM noteModels")
    fun getAll(): LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModel: NoteModel)

    @Delete
    fun deleteNote(noteModel: NoteModel)

    @Query("SELECT * FROM noteModels WHERE id = :id")
    fun getNote(id:Int):NoteModel

    @Update
    fun updateNote(noteModel: NoteModel)
}