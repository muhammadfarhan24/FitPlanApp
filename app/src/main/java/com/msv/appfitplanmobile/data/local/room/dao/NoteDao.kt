package com.msv.appfitplanmobile.data.local.room.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.msv.appfitplanmobile.data.local.room.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes WHERE date = :date")
    fun getNoteByDate(date: String): Flow<Note?>

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<Note>>
}