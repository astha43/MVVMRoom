package com.example.mvvmapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmapplication.model.Notes

@Dao
interface NotesDAO {

    @Insert
    suspend fun insertNotes(notes: Notes)

    @Delete
    suspend fun deleteNotes(notes: Notes)

    @Query("SELECT * FROM notes")
    fun getNotes() : LiveData<List<Notes>>
}