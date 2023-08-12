package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import com.example.app_24_moviesapplication.data.api.TMDBService
import com.example.app_24_moviesapplication.data.database.TMDBDatabase
import com.example.app_24_moviesapplication.data.datasource.MoviesRemoteDataSource
import com.example.app_24_moviesapplication.data.datasourceimplementation.MovieRemoteImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val api : String) {

    @Singleton
    @Provides
    fun provideRemoteData(tmdb : TMDBService) : MoviesRemoteDataSource{
        return MovieRemoteImpl(tmdb, api)
    }

}