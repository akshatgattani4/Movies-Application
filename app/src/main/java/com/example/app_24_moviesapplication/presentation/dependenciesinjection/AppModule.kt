package com.example.app_24_moviesapplication.presentation.dependenciesinjection

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext() : Context{
        return context.applicationContext
    }
}