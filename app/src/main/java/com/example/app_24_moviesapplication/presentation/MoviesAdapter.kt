package com.example.app_24_moviesapplication.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_24_moviesapplication.R
import com.example.app_24_moviesapplication.data.model.Movie
import com.example.app_24_moviesapplication.databinding.ListItemBinding

class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies : List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie : Movie){
            binding.title.text = movie.title
            binding.description.text = movie.overview
            val path = "https://image.tmdb.org/t/p/w500" + movie.poster_path
            Glide.with(binding.img.context).load(path).into(binding.img)
        }
    }
}