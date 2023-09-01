package com.example.notesapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.notesapp.LocalDB.NotesRepository
import com.example.notesapp.Models.NotesModel
import com.example.notesapp.R

//
class Text : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)

    }

    private fun initView(view:View) {

        val notesRepository = NotesRepository(requireActivity().application)
        val notesModel:ArrayList<NotesModel> = ArrayList()
        val tvText: TextView =view.findViewById(R.id.tvText_fr)
        val id=arguments?.getInt("id")
        val btnCancel:Button=view.findViewById(R.id.btnCancel_fr)
        val llRoot:LinearLayout=view.findViewById(R.id.llRoot_fr)

        btnCancel.setOnClickListener {

            llRoot.visibility=View.GONE

        }


        tvText.text= id?.let { notesRepository.getTextById(it).toString() }

    }

}