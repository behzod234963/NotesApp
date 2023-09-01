package com.example.notesapp.LocalDB

import android.app.Application
import com.example.notesapp.Models.NotesModel

class NotesRepository(val app:Application) {

    var notesDao=NotesDBCore.notesDataBase(app).getDao()

    fun getAll():List<NotesModel>{

        return notesDao.getText()

    }

    fun saveNotes(note:NotesModel){

        notesDao.saveText(note)

    }

    fun clearAll(note:List<NotesModel>){

        notesDao.clearAll(note)

    }

    fun getTextById(id: Int): NotesModel {

        return notesDao.getTextById(id)

    }

}