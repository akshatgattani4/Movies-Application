package com.example.app_24_moviesapplication.data.datasourceimplementation

import com.example.app_24_moviesapplication.data.api.TMDBService
import com.example.app_24_moviesapplication.data.datasource.MoviesRemoteDataSource
import com.example.app_24_moviesapplication.data.model.MoviesList
import retrofit2.Response

class MovieRemoteImpl(
    private val TMDB : TMDBService,
    private val api : String
) : MoviesRemoteDataSource{

    override suspend fun getMovies(): Response<MoviesList> = TMDB.getMovies(api)

}