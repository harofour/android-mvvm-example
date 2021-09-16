package com.example.mvvm_example.retrofit

import com.example.mvvm_example.SearchMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET(".")
    fun getSearchMovie(
        @Query("apikey") apikey: String,
        @Query("s") title: String,
        @Query("type") type: String="movie"
    ) : Call<SearchMovie>
}