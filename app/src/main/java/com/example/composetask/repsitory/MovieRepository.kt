package com.example.composetask.repsitory

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val api: MovieApi
) {
    suspend fun getMovies() = api.getMovies()
}