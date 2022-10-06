package com.example.flagkotlinapicoroutine.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.flagkotlinapicoroutine.data.model.Movie
import com.example.flagkotlinapicoroutine.databinding.ItemMovieBinding

class MovieListAdapter(var movies: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

/*    fun updateCountries(newCountry: List<Movie>) {
        countries.clear()
        countries.add(newCountry)
        notifyDataSetChanged()
    }*/

/*
    @BindingAdapter("poster")
    fun loadImage(imgView: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            poster?.let {
                val imgUri = it.toUri().buildUpon().scheme("https").build()
                Glide.with(imgView.context)
                    .load(imgUri)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image))
                    .into(imgView)
            }
        }
    }
*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val listItemMovieBinding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(listItemMovieBinding)

    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        /*   private val imageView: ImageView = itemView.findViewById(R.id.imgPoster)
           private val titleMovie: TextView = itemView.findViewById(R.id.tvTitle)
           private val releaseMovie: TextView = itemView.findViewById(R.id.tvReleaseDate)*/

        fun bind(item: Movie) {
/*            binding.tvTitle = item.title
            releaseMovie.text = movie.release
            imageView.loadImage(BuildConfig.BASE_IMAGE + movie.poster)*/
            binding.setVariable(BR.movie, item)
            binding.executePendingBindings();
        }

    }

}