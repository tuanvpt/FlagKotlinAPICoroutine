package com.example.flagkotlinapicoroutine.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flagkotlinapicoroutine.data.model.Movie
import com.example.flagkotlinapicoroutine.data.model.reponse.MovieResponse
import com.example.flagkotlinapicoroutine.data.services.MovieApiInterface
import com.example.flagkotlinapicoroutine.data.services.MovieApiService
import com.example.flagkotlinapicoroutine.databinding.ActivityMainBinding
import com.example.flagkotlinapicoroutine.viewmodel.ListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel

    /*private val countriesAdapter = MovieListAdapter(arrayListOf())*/
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            getMovieData { movies: List<Movie> ->
                this.adapter = MovieListAdapter(movies as ArrayList<Movie>)
            }

        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)

        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })
    }

    private fun registerLiveData() {


    }


}
