package com.example.mvvm_example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_example.Movie

class MovieViewModel() : ViewModel() {
    private val repository = Repository()
    var searchTerm : String? = null

    fun searchMovieData(apiKey: String, title: String) {
        repository.searchMovieData(apiKey, title)
    }

    fun getMovieData(): LiveData<List<Movie>> {
        return repository.movies
    }
}