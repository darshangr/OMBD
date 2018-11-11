package com.rootminusone.omdbapp.com.rootminusone.omdbapp

import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.com.rootminusone.omdbapp.util.OMDBAPIRequest
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieData
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieDataDao
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieDatabase
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(val movieDataDao: MovieDataDao?) {

    private val movieService by lazy { OMDBAPIRequest.create() }

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: MovieRepository? = null

        fun getInstance(movieDataDao: MovieDataDao?) =
                instance ?: synchronized(this) {
                    instance ?: MovieRepository(movieDataDao).also { instance = it }
                }
    }

     fun getMovieList(searchString : String) : LiveData<MovieResponse> {

         val responseList = MutableLiveData<MovieResponse>()

         movieService.getMovieList(searchString).enqueue(object : Callback<MovieResponse> {
             override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                 if (response != null && response.isSuccessful && response.body() != null) {
                     responseList.value = response.body() as MovieResponse
                 }

             }

             override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                 Log.d("Failure in MovieRepository: ", t.message)

                responseList.value = MovieResponse(error = "true")


             }

         }

         )
        return responseList
     }

    fun addFavorite(movieData: MovieData) {
        movieDataDao?.insertMovie(movieData)
    }

    fun fetchFavoriteMovies() : LiveData<List<MovieData>>? = movieDataDao?.getAllMovies()

}