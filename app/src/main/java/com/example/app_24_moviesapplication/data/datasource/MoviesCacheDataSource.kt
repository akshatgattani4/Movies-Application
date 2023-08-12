package com.example.app_24_moviesapplication.data.datasource

import com.example.app_24_moviesapplication.data.model.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)
}