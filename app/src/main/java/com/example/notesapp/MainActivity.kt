package com.example.notesapp

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Adapters.NotesAdapter
import com.example.notesapp.Fragments.Text
import com.example.notesapp.LocalDB.NotesRepository
import com.example.notesapp.Models.NotesModel
import android.view.KeyEvent

class MainActivity : AppCompatActivity() {

    lateinit var notesRepository: NotesRepository
    lateinit var noteList:ArrayList<NotesModel>
    lateinit var notesAdapter: NotesAdapter
    lateinit var btnCreate: Button
    lateinit var ivClear: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {

        notesRepository = NotesRepository(application)
        loadNotes()
        val btnBackButton:Button?=findViewById(R.id.backButton)
        val rlText:RelativeLayout=findViewById(R.id.rlText)
        val rvMain: RecyclerView = findViewById(R.id.rvMain)
        notesAdapter=NotesAdapter()
        btnCreate = findViewById(R.id.btnCreate)
        ivClear=findViewById(R.id.ivClear)
        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.adapter=notesAdapter
        notesAdapter.submitList(noteList)

        btnBackButton?.setOnKeyListener { _, keyCode, event ->



            if (keyCode==KeyEvent.KEYCODE_BACK && event.action==KeyEvent.ACTION_DOWN){

                return@setOnKeyListener true

            }

            return@setOnKeyListener false

        }

        notesAdapter.onClick={

            rlText.visibility = View.VISIBLE
            val fragmentText=Text()
            val text=noteList[it].text
            val id=noteList[it].id
            val bundle=Bundle()
            bundle.putInt("id",id!!)
            fragmentText.arguments=bundle
            setFragment(fragmentText)



        }

        btnCreate.setOnClickListener {

            createDialog()
            loadNotes()
            notesAdapter.submitList(noteList)

        }

        ivClear.setOnClickListener {

            clearList(noteList)
            loadNotes()
            notesAdapter.submitList(noteList)

        }

    }

    @SuppressLint("ResourceType")
    private fun createDialog() {

        val dialog = Dialog(this,R.color.white)
        dialog.setContentView(R.layout.item_dialog)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        val etText: EditText? = dialog.findViewById(R.id.etText)
        val ivCancel: ImageView? = dialog.findViewById(R.id.ivCancel)
        val btnSave: Button? = dialog.findViewById(R.id.btnSave)

        ivCancel?.setOnClickListener {

            dialog.dismiss()

        }

        btnSave?.setOnClickListener {

            loadNotes()
            notesAdapter.submitList(noteList)
            val note = NotesModel(null, "September 1", etText?.text.toString())
            notesRepository.saveNotes(note)
            loadNotes()
            notesAdapter.submitList(noteList)
            dialog.dismiss()

        }

        dialog.show()
        loadNotes()
        notesAdapter.submitList(noteList)

    }

    private fun loadNotes() {

        noteList= ArrayList()
        noteList = notesRepository.getAll() as ArrayList<NotesModel>

    }

    fun clearList(note: ArrayList<NotesModel>){

        notesRepository.clearAll(note)

    }

    @SuppressLint("ResourceType")
    fun setFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.frText,fragment).commit()

    }


}