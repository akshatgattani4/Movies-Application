package com.example.app_24_moviesapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app_24_moviesapplication.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun movieDAO() : MovieDAO
}