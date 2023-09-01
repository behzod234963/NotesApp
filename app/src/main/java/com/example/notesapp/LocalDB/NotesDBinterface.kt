package com.example.notesapp.LocalDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesapp.Models.NotesModel

@Dao
interface NotesDBinterface {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun saveText(note: NotesModel)

    @Query("SELECT *FROM notes")
    fun getText():List<NotesModel>

    @Query("SELECT *FROM notes WHERE :id=id")
    fun getTextById(id:Int):NotesModel

    @Delete
    fun clearAll(note: List<NotesModel>)

}