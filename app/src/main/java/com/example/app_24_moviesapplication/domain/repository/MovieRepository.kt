package com.example.app_24_moviesapplication.domain.repository

import com.example.app_24_moviesapplication.data.model.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}