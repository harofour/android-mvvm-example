package com.example.mvvm_example

import com.google.gson.annotations.SerializedName

data class SearchMovie(
    @SerializedName("Search")
    val movieList: List<Movie>
)

data class Movie(
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("Poster")
    val poster_path: String
) {
    val yearText: String
        get() {
            return "(%s)".format(year)
        }
}