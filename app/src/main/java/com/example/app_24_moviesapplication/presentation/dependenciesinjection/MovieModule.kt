package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import com.example.app_24_moviesapplication.domain.usecases.GetMoviesUseCase
import com.example.app_24_moviesapplication.domain.usecases.UpdateMoviesUseCase
import com.example.app_24_moviesapplication.presentation.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MoviesViewModelFactory{
        return MoviesViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
    }
}