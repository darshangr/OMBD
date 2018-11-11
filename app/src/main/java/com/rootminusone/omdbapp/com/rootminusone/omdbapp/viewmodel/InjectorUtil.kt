package com.rootminusone.omdbapp.com.rootminusone.omdbapp.viewmodel

import android.app.Application
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.MovieRepository
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieDatabase

object InjectorUtil {

    fun provideMovieViewModelFactory(application: Application): MovieViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = MovieRepository.getInstance(MovieDatabase.getInstance(application)?.movieDataDao())
        return MovieViewModelFactory(application, quoteRepository)
    }
}