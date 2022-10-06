package com.example.flagkotlinapicoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flagkotlinapicoroutine.data.model.Movie
import com.example.flagkotlinapicoroutine.data.model.reponse.MovieResponse
import com.example.flagkotlinapicoroutine.data.services.MovieApiService
import kotlinx.coroutines.*
import retrofit2.Response

class ListViewModel : ViewModel() {

/*
    private val countries = MutableLiveData<Country>()
*/

    val movieService = MovieApiService.getMovieService()
    val movies = MutableLiveData<List<Movie>>()

    val movieResponse = MutableLiveData<MovieResponse>()
    val movieLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()


    private var job: Job? = null
    private val exception = CoroutineExceptionHandler { _, throwable ->

        onError("Exception ${throwable.localizedMessage}")
    }


    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true

        job = CoroutineScope(Dispatchers.IO + exception).launch {
            val response: Response<MovieResponse> = movieService.getMovieList()
            if (response.isSuccessful) {
                movieResponse.value = response.body()
                movieLoadError.value = null
                loading.value = false
            } else {
                onError("Error:  ${response.message()}")
            }
        }

    }

    private fun onError(message: String) {
        movieLoadError.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}