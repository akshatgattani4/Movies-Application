package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import com.example.app_24_moviesapplication.domain.repository.MovieRepository
import com.example.app_24_moviesapplication.domain.usecases.GetMoviesUseCase
import com.example.app_24_moviesapplication.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }
}