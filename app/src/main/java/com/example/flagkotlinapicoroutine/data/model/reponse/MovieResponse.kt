package com.example.flagkotlinapicoroutine.data.model.reponse

import android.os.Parcelable
import com.example.flagkotlinapicoroutine.data.model.Movie
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>,

    ) : Parcelable {
    constructor() : this(mutableListOf())
}