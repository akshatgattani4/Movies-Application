package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app_24_moviesapplication.data.database.MovieDAO
import com.example.app_24_moviesapplication.data.database.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context,
        TMDBDatabase::class.java,
        "tmdbClient").build()
    }

    @Singleton
    @Provides
    fun provideDAO(tmdb : TMDBDatabase) : MovieDAO{
        return tmdb.movieDAO()
    }
}