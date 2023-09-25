package com.example.notesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentAddNoteBinding
import com.example.notesapp.databinding.FragmentMainBinding
import com.example.notesapp.models.NotesModel
import com.example.notesapp.viewModel.fragmentAdd.AddViewModel

class AddNote : Fragment() {

    lateinit var binding: FragmentAddNoteBinding
    lateinit var navController: NavController
    lateinit var notes: ArrayList<NotesModel>
    lateinit var addViewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        notes = ArrayList()
        navController = NavController(requireContext())
        binding.apply {

            lavBtnBackAdd.setOnClickListener { onBtnBackListener() }
            lavBtnSaveAdd.setOnClickListener { onBtnSaveListener() }

        }

    }


//    Listener for button save
    private fun onBtnSaveListener() {

        binding.apply {

            lavBtnSaveAdd.playAnimation()
            val title=etTitle.text
            val text=etText.text

            addViewModel.saveNote(
                NotesModel( null,
                    title.toString(),
                    text.toString())
            )

            findNavController().navigate(R.id.action_addNote_to_main)
            navController.popBackStack()

        }

    }


    //    Listener for back button
    private fun onBtnBackListener() {

        binding.lavBtnBackAdd.playAnimation()
        findNavController().navigate(R.id.action_addNote_to_main)
        navController.popBackStack()

    }

}