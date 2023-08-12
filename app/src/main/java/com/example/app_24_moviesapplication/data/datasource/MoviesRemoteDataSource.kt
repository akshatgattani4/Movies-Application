package com.example.app_24_moviesapplication.data.datasource

import com.example.app_24_moviesapplication.data.model.MoviesList
import retrofit2.Response

interface MoviesRemoteDataSource {
    suspend fun getMovies() : Response<MoviesList>
}