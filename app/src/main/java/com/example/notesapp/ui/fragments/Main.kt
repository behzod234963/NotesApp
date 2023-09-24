package com.example.notesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.R
import com.example.notesapp.adapters.MainAdapter
import com.example.notesapp.databinding.FragmentMainBinding
import com.example.notesapp.models.NotesModel
import com.example.notesapp.viewModel.fragmentMain.MainViewModel

class Main : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var notes: ArrayList<NotesModel>
    lateinit var mainViewModel: MainViewModel
    lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root

        initViews()

    }


    //    Initializing views in this fragment
    private fun initViews() {

        binding.apply {

            isVisibile(lavLoading)
            isVisibile(lavBtnAddLoop)
            inVisible(lavBtnAddClick)
            initViewModel()
            setupObserve()
            mainAdapter = MainAdapter()
            notes = ArrayList()
            rvMain.adapter = mainAdapter
            mainAdapter.submitList(notes)

        }

    }


    //    Making views invisible
    private fun inVisible(view: View) {

        view.visibility = View.GONE

    }


    //    Making views visible
    private fun isVisibile(view: View) {

        view.visibility = View.VISIBLE

    }


    //    Setting observe for ViewModel
    private fun setupObserve() {

        mainViewModel.notes.observe(viewLifecycleOwner) {

            setData(it as ArrayList<NotesModel>)

        }

        mainViewModel.fetchData()

    }


    //    Setting data
    private fun setData(notesModels: java.util.ArrayList<NotesModel>) {

        mainAdapter.submitList(notes)

    }


    //      Initializing ViewModel
    private fun initViewModel() {

        mainViewModel = ViewModelProvider(this@Main)[MainViewModel::class.java]

    }
}