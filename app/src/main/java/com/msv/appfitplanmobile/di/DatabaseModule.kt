package com.msv.appfitplanmobile.di
import android.content.Context
import androidx.room.Room
import com.msv.appfitplanmobile.data.local.room.AppDatabase
import com.msv.appfitplanmobile.data.local.room.dao.BodyDao
import com.msv.appfitplanmobile.data.local.room.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "note_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.noteDao()
    }
    @Provides
    fun provideBodyDao(database: AppDatabase): BodyDao {
        return database.bodyDao()
    }
}
