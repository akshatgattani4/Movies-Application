package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import com.example.app_24_moviesapplication.data.datasource.MoviesCacheDataSource
import com.example.app_24_moviesapplication.data.datasourceimplementation.MovieCacheImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideCacheData() : MoviesCacheDataSource{
        return MovieCacheImpl()
    }
}