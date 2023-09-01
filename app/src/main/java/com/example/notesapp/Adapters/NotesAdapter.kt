package com.example.notesapp.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Models.NotesModel
import com.example.notesapp.R

class NotesAdapter :RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){

    private val notesList:ArrayList<NotesModel> = ArrayList()

    var onClick:((Int)->Unit)? =null

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list:ArrayList<NotesModel>){

        this.notesList.clear()
        this.notesList.addAll(list)
        notifyDataSetChanged()

    }

    class NotesViewHolder(view: View):RecyclerView.ViewHolder(view){

        val tvText:TextView=view.findViewById(R.id.tvText)
        val tvData:TextView=view.findViewById(R.id.tvData)
        val llItem:LinearLayout=view.findViewById(R.id.llItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        return NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes,parent,false))

    }

    override fun getItemCount(): Int {

        return notesList.size

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        val l=notesList[position]

        holder.tvText.text=l.text
        holder.tvData.text=l.data

        holder.llItem.setOnClickListener {

            onClick?.invoke(position)

        }

    }

}