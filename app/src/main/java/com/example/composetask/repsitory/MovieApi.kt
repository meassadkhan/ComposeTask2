package com.example.composetask.repsitory

import com.example.composetask.model.Movie
import retrofit2.http.GET

interface MovieApi {
    @GET("movielist.json")
    suspend fun getMovies(): List<Movie>
}