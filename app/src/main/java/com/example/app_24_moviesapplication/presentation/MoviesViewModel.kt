package com.example.app_24_moviesapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.app_24_moviesapplication.domain.usecases.GetMoviesUseCase
import com.example.app_24_moviesapplication.domain.usecases.UpdateMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel(){

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}