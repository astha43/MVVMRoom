package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapplication.repository.NotesRepository


class MainViewModelFactory(private var notesRepository: NotesRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(notesRepository) as T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}