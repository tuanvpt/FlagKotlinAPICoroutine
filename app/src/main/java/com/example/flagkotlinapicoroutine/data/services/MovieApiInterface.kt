package com.example.flagkotlinapicoroutine.data.services

import com.example.flagkotlinapicoroutine.data.model.reponse.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=63e2a9c698c55e8514bed6801145816a&language=en-US&page=1")
    suspend fun getMovieList(): Response<MovieResponse>
}