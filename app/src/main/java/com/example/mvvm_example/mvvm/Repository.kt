package com.example.mvvm_example.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_example.Movie
import com.example.mvvm_example.SearchMovie
import com.example.mvvm_example.retrofit.MovieAPI
import com.example.mvvm_example.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Repository {
    private val retrofit: Retrofit = RetrofitClient.getInstance()
    private val api = retrofit.create(MovieAPI::class.java)

    val movies = MutableLiveData<List<Movie>>()

    fun searchMovieData(apiKey: String, title: String) {
        api.getSearchMovie(apiKey, title).enqueue(object : Callback<SearchMovie> {
            override fun onResponse(call: Call<SearchMovie>, response: Response<SearchMovie>) {
                movies.value = response.body()!!.movieList
            }

            override fun onFailure(call: Call<SearchMovie>, t: Throwable) {
                t.stackTrace
            }
        })
    }
}