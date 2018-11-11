package com.rootminusone.omdbapp.com.rootminusone.omdbapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.MovieRepository

class MovieViewModelFactory(private val application: Application, private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(application,movieRepository) as T
    }
}