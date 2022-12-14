package com.example.mvvmapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String
)
