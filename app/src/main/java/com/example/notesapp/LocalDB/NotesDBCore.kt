package com.example.notesapp.LocalDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.Models.NotesModel

@Database(entities = [NotesModel::class], version = 1)
abstract class NotesDBCore:RoomDatabase() {

    abstract fun getDao(): NotesDBinterface

    companion object {

        private var DB_INSTANCE: NotesDBCore? = null

        fun notesDataBase(ctx: Context): NotesDBCore {

            if (DB_INSTANCE==null){

                DB_INSTANCE =
                    Room.databaseBuilder(ctx.applicationContext, NotesDBCore::class.java, "note")
                        .allowMainThreadQueries().build()

            }

            return DB_INSTANCE!!

        }

    }

}