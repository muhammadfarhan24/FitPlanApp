package com.msv.appfitplanmobile.di

import android.content.Context
import com.msv.appfitplanmobile.data.local.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): Preferences =
        Preferences(
            context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        )
}