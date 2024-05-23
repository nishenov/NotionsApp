package com.example.notionsapp.interfaces

import com.example.notionsapp.data.models.NoteModel

interface OnClickItem {
    fun onLongClick(noteModel: NoteModel)
    fun onClick(noteModel: NoteModel)
}