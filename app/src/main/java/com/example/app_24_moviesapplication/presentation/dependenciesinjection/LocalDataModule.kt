package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import com.example.app_24_moviesapplication.data.database.MovieDAO
import com.example.app_24_moviesapplication.data.datasource.MoviesLocalDataSource
import com.example.app_24_moviesapplication.data.datasourceimplementation.MovieLocalImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalData(dao : MovieDAO) : MoviesLocalDataSource{
        return MovieLocalImpl(dao)
    }
}