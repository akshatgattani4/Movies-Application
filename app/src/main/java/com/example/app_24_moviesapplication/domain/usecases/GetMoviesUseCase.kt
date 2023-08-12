package com.example.app_24_moviesapplication.domain.usecases

import com.example.app_24_moviesapplication.data.model.Movie
import com.example.app_24_moviesapplication.domain.repository.MovieRepository

class GetMoviesUseCase(val repository: MovieRepository) {
    suspend fun execute() : List<Movie>? = repository.getMovies()
}