package com.example.flagkotlinapicoroutine.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flagkotlinapicoroutine.databinding.ActivityMainBinding
import com.example.flagkotlinapicoroutine.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel

    private lateinit var binding: ActivityMainBinding
    private val moviesAdapter = MovieListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]



        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = moviesAdapter

        }

        registerLiveData()
    }

    /*   private fun getMovieData(callback: (List<Movie>) -> Unit) {
           val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
           apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
               override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                   return callback(response.body()!!.movies)
               }

               override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
               }
           })
       }*/


    private fun registerLiveData() {

        viewModel.movies.observe(this) { movies ->
            movies?.let {
                binding.rvMovie.visibility = View.VISIBLE
                moviesAdapter.updateMovies(it)
            }
        }

        viewModel.movieLoadError.observe(this) { isError ->
            binding.listError.visibility = if (isError == "") View.GONE else View.VISIBLE
        }


        viewModel.loading.observe(this) { isLoading ->
            isLoading?.let {
                binding.pbLoading.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.rvMovie.visibility = View.GONE
                    binding.rvMovie.visibility = View.GONE
                }
            }
        }

    }


}
