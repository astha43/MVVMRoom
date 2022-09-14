package com.example.mvvmapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmapplication.model.Notes

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDAO() : NotesDAO

    companion object{
        @Volatile
        private var INSTANCE : NotesDatabase? = null

        fun getDatabase(context: Context) : NotesDatabase {
            synchronized(this) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                        context, NotesDatabase::class.java,
                        "notesDB"
                    ).build()
                }
            }
                return INSTANCE!!
        }
    }
}