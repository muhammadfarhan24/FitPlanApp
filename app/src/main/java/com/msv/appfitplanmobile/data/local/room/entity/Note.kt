package com.msv.appfitplanmobile.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val date: String, // format DDMMYYYY
    val note: String
)
