package com.example.mvvm_example.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_example.Movie

class MovieViewModel() : ViewModel() {
    private val repository = Repository()
    private val searchTerm = MutableLiveData<String>()

    fun searchMovieData(apiKey: String, title: String) {
        repository.searchMovieData(apiKey, title)
    }

    fun getMovieData(): LiveData<List<Movie>> {
        return repository.movies
    }
}