package com.example.notesapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.models.NotesModel
import com.example.notesapp.utils.MainDiffUtils
import com.example.notesapp.viewHolder.MainViewHolder

class MainAdapter:RecyclerView.Adapter<MainViewHolder>() {

    var itemClick:((Int)->Unit)?=null
    var notes:ArrayList<NotesModel> =ArrayList()

    fun submitList(newNotes:ArrayList<NotesModel>){

        val mainDiffUtils=MainDiffUtils(notes,newNotes)
        val calculateItems=DiffUtil.calculateDiff(mainDiffUtils)
        notes=newNotes
        calculateItems.dispatchUpdatesTo(this)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =

        MainViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_main,parent,false))

    override fun getItemCount(): Int=notes.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val note=notes[position]

        holder.apply {

            llItemClick.setOnClickListener {

                itemClick?.invoke(position)

            }

            tvTitle.text=note.title
            tvText.text=note.text

        }

    }
}