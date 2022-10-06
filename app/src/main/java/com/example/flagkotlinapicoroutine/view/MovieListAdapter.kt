package com.example.flagkotlinapicoroutine.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flagkotlinapicoroutine.BuildConfig
import com.example.flagkotlinapicoroutine.R
import com.example.flagkotlinapicoroutine.Utils.exts.loadImage
import com.example.flagkotlinapicoroutine.data.model.Movie
import com.example.flagkotlinapicoroutine.data.model.reponse.MovieResponse

class MovieListAdapter(var movies: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieListAdapter.CountryViewHolder>() {

    fun updateMovies(newCountry: List<Movie>) {
        movies.clear()
        movies.addAll(newCountry)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val titleMovie: TextView = itemView.findViewById(R.id.tvTitle)
        private val releaseMovie: TextView = itemView.findViewById(R.id.tvReleaseDate)

        fun bind(movie: Movie) {
            titleMovie.text = movie.title
            releaseMovie.text = movie.release
            imageView.loadImage(BuildConfig.BASE_IMAGE + movie.poster)
        }

    }

}