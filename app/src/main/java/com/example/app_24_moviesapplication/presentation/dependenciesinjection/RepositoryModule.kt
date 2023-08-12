package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import com.example.app_24_moviesapplication.data.RepositoryImpl
import com.example.app_24_moviesapplication.data.datasource.MoviesCacheDataSource
import com.example.app_24_moviesapplication.data.datasource.MoviesLocalDataSource
import com.example.app_24_moviesapplication.data.datasource.MoviesRemoteDataSource
import com.example.app_24_moviesapplication.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRespository(
        remote : MoviesRemoteDataSource,
        local : MoviesLocalDataSource,
        cache : MoviesCacheDataSource
    ) : MovieRepository{
        return RepositoryImpl(remote,local,cache)
    }
}