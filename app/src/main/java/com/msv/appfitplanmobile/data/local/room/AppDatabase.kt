package com.msv.appfitplanmobile.data.local.room
import androidx.room.Database
import androidx.room.RoomDatabase
import com.msv.appfitplanmobile.data.local.room.dao.BodyDao
import com.msv.appfitplanmobile.data.local.room.dao.NoteDao
import com.msv.appfitplanmobile.data.local.room.entity.Body
import com.msv.appfitplanmobile.data.local.room.entity.Note

@Database(entities = [Note::class, Body::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun bodyDao(): BodyDao
}
