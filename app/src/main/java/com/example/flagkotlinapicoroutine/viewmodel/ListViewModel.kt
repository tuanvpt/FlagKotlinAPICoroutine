package com.example.flagkotlinapicoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

/*
    private val countries = MutableLiveData<Country>()
*/
    private val countryLoadError = MutableLiveData<String?>()
    private val loading = MutableLiveData<Boolean>()


    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true

/*        val dummyData = generateDummyCountries()

        countries.value = dummyData*/
        countryLoadError.value = ""
        loading.value = false
    }




    private fun onError(message: String) {
        countryLoadError.value = message
        loading.value = false
    }



}