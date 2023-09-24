package com.example.notesapp.viewModel.fragmentMain

import android.widget.Toast
import com.example.notesapp.models.NotesModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {

    val fireBaseReference=FirebaseDatabase.getInstance().reference

    fun getAllNotes(callback:(List<NotesModel>)->Unit){

        fireBaseReference.child("notes").addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                val notes= mutableListOf<NotesModel>()
                for (dataSnapshot in snapshot.children ){

                    val data=snapshot.getValue(NotesModel::class.java)
                    data.let {
                        if (it != null) {
                            notes.add(it)
                        }
                    }

                }

                callback(notes)

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }

}