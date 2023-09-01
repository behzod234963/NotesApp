package com.example.notesapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NotesModel(

    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val data:String,
    val text:String) {
    override fun toString(): String {
        return text
    }
}
