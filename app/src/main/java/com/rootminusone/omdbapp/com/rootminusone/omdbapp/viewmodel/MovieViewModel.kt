package com.rootminusone.omdbapp.com.rootminusone.omdbapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.MovieRepository
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieData

class MovieViewModel(application: Application, val movieRepository: MovieRepository) : AndroidViewModel(application) {

    fun getMovieList(searchString: String) = movieRepository.getMovieList(searchString)

    fun addFavorite(movieData: MovieData) = movieRepository.addFavorite(movieData)

    fun fetchFavorites() = movieRepository.fetchFavoriteMovies()

}