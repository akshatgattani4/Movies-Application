package com.example.app_24_moviesapplication

import android.app.Application
import com.example.app_24_moviesapplication.presentation.dependenciesinjection.AppComponent
import com.example.app_24_moviesapplication.presentation.dependenciesinjection.AppModule
import com.example.app_24_moviesapplication.presentation.dependenciesinjection.DaggerAppComponent
import com.example.app_24_moviesapplication.presentation.dependenciesinjection.Injector
import com.example.app_24_moviesapplication.presentation.dependenciesinjection.MovieSubComponent
import com.example.app_24_moviesapplication.presentation.dependenciesinjection.NetModule
import com.example.app_24_moviesapplication.presentation.dependenciesinjection.RemoteDataModule

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}