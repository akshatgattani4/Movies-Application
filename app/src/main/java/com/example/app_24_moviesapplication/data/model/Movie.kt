package com.example.app_24_moviesapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movies")
data class Movie(
    @PrimaryKey
    val id : Int,
    val overview : String,
    val poster_path : String,
    val release_date : String,
    val title : String,
)
