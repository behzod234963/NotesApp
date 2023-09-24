package com.example.notesapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.notesapp.models.NotesModel

class MainDiffUtils(
    val oldNotes:ArrayList<NotesModel>,
    val newNotes:ArrayList<NotesModel>):DiffUtil.Callback() {
    override fun getOldListSize(): Int=oldNotes.size

    override fun getNewListSize(): Int =newNotes.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =

        oldNotes[oldItemPosition].id==newNotes[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =

        oldNotes==newNotes

}