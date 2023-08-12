package com.example.app_24_moviesapplication.data.datasourceimplementation

import androidx.room.Dao
import com.example.app_24_moviesapplication.data.database.MovieDAO
import com.example.app_24_moviesapplication.data.datasource.MoviesLocalDataSource
import com.example.app_24_moviesapplication.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MovieLocalImpl(
    private val dao: MovieDAO
) : MoviesLocalDataSource{
    override suspend fun getMoviesFromDB(): List<Movie> {
        return dao.getAllMovies()
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.save(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllMovies()
        }
    }

}