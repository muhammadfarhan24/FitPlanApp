package com.msv.appfitplanmobile.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.msv.appfitplanmobile.data.local.room.entity.Body
import kotlinx.coroutines.flow.Flow

@Dao
interface BodyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(body: Body)

    @Query("SELECT * FROM bodies WHERE date = :date")
    fun getBodyByDate(date: String): Flow<Body?>

    @Query("SELECT * FROM bodies")
    fun getAllBodies(): Flow<List<Body>>
}
