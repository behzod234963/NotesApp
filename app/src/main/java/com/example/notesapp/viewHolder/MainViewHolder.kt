package com.example.notesapp.viewHolder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R

class MainViewHolder(view:View) :RecyclerView.ViewHolder(view){

    val llItemClick:LinearLayout=view.findViewById(R.id.llNotesClick_item)
    val tvTitle:TextView=view.findViewById(R.id.tvTitle_item)
    val tvText:TextView=view.findViewById(R.id.tvText_item)

}