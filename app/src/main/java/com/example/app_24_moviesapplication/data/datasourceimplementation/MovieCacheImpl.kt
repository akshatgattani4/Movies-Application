package com.example.app_24_moviesapplication.data.datasourceimplementation

import com.example.app_24_moviesapplication.data.datasource.MoviesCacheDataSource
import com.example.app_24_moviesapplication.data.model.Movie

class MovieCacheImpl : MoviesCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}