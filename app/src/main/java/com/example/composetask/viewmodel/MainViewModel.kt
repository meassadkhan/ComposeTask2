package com.example.composetask.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composetask.model.Movie
import com.example.composetask.repsitory.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    suspend fun getMovies(): List<Movie> {
        return repository.getMovies()
    }
}