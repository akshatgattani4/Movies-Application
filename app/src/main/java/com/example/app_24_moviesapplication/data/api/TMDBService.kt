package com.example.app_24_moviesapplication.data.api

import com.example.app_24_moviesapplication.data.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey : String
    ) : Response<MoviesList>
}