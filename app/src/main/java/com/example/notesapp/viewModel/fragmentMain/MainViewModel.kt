package com.example.notesapp.viewModel.fragmentMain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.models.NotesModel
import com.google.firebase.database.FirebaseDatabase

class MainViewModel(private val repository: MainRepository):ViewModel() {

    val _notes= MutableLiveData<List<NotesModel>>()
    val notes:LiveData<List<NotesModel>>get() = _notes

    fun fetchData(){

        repository.getAllNotes { notes->

            _notes.postValue(notes)

        }

    }

}