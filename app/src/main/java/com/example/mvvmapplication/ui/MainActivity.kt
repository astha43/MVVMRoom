package com.example.mvvmapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapplication.database.NotesDatabase
import com.example.mvvmapplication.databinding.ActivityMainBinding
import com.example.mvvmapplication.model.Notes
import com.example.mvvmapplication.repository.NotesRepository
import com.example.mvvmapplication.viewmodel.MainViewModel
import com.example.mvvmapplication.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val notesDAO = NotesDatabase.getDatabase(applicationContext).notesDAO()

        val notesRepository = NotesRepository(notesDAO)

        val mainViewModel = ViewModelProvider(this, MainViewModelFactory(notesRepository)).get(
            MainViewModel::class.java)

        mainViewModel.getNotes().observe(this, {
            binding.textView.text = it.toString()

        })

        binding.button.setOnClickListener {
            if(binding.editText.text!!.isEmpty()){
                binding.editText.error = "Error"
            }else{
                mainViewModel.insertNotes(Notes(0,binding.editText.text.toString()))
                Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show()
                binding.editText.text = null
            }
        }
    }
}