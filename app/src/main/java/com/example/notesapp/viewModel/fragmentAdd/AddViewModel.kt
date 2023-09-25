package com.example.notesapp.viewModel.fragmentAdd

import androidx.lifecycle.ViewModel
import com.example.notesapp.models.NotesModel
import com.google.firebase.database.FirebaseDatabase

class AddViewModel :ViewModel(){

    val dataBaseReference=FirebaseDatabase.getInstance().getReference("notes")

    fun saveNote(note:NotesModel){

        val noteId=dataBaseReference.push().key
        noteId.let {

            dataBaseReference.child(it!!).setValue(note)

        }

    }

}