package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapplication.repository.NotesRepository
import com.example.mvvmapplication.model.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private var notesRepository: NotesRepository) : ViewModel() {


    fun getNotes() : LiveData<List<Notes>>{
        return notesRepository.getNotes()
    }

    fun insertNotes(notes: Notes) {
        viewModelScope.launch (Dispatchers.IO){
            notesRepository.insertNotes(notes)
        }
    }
}