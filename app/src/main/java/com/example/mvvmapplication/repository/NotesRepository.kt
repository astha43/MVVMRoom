package com.example.mvvmapplication.repository

import androidx.lifecycle.LiveData
import com.example.mvvmapplication.database.NotesDAO
import com.example.mvvmapplication.model.Notes

class NotesRepository(private var notesDAO: NotesDAO) {

    suspend fun insertNotes(notes: Notes){
        notesDAO.insertNotes(notes)
    }

    fun getNotes() : LiveData<List<Notes>>{
        return notesDAO.getNotes()
    }
}