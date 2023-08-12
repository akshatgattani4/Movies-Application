package com.example.app_24_moviesapplication.data

import com.example.app_24_moviesapplication.data.datasource.MoviesCacheDataSource
import com.example.app_24_moviesapplication.data.datasource.MoviesLocalDataSource
import com.example.app_24_moviesapplication.data.datasource.MoviesRemoteDataSource
import com.example.app_24_moviesapplication.data.model.Movie
import com.example.app_24_moviesapplication.domain.repository.MovieRepository

class RepositoryImpl(
    private val remote : MoviesRemoteDataSource,
    private val local : MoviesLocalDataSource,
    private val cache : MoviesCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMovies = getMoviesFromAPI()
        local.clearAll()
        local.saveMovies(newMovies)
        cache.saveMoviesToCache(newMovies)
        return newMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList : List<Movie>

        try {
            val response = remote.getMovies()
            val body = response.body()

            if(body != null){
                movieList = body.movies
            }
        }catch (exception : java.lang.Exception){

        }
        return movieList
    }

    suspend fun getMoviesFromRoom() : List<Movie>{
        lateinit var movieList : List<Movie>

        try{
            movieList = local.getMoviesFromDB()
        }catch (exception : java.lang.Exception){

        }
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            local.saveMovies(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList : List<Movie>

        try{
            movieList = cache.getMoviesFromCache()
        }catch (exception : java.lang.Exception){

        }
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromRoom()
            cache.saveMoviesToCache(movieList)
        }
        return movieList
    }
}