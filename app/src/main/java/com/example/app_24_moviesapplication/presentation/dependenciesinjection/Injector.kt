package com.example.app_24_moviesapplication.presentation.dependenciesinjection

interface Injector {
    fun createMovieSubComponent() : MovieSubComponent
}