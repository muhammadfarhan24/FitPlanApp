package com.msv.appfitplanmobile.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bodies")
data class Body(
    @PrimaryKey val date: String, // format DD/MM/YYYY
    val weight: Int,
    val height: Int
)
