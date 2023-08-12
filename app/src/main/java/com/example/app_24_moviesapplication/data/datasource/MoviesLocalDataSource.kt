package com.example.app_24_moviesapplication.data.datasource

import com.example.app_24_moviesapplication.data.model.Movie

interface MoviesLocalDataSource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMovies(movies : List<Movie>)
    suspend fun clearAll()
}