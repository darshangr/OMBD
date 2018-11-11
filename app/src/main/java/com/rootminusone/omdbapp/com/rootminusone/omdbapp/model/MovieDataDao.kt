package com.rootminusone.omdbapp.com.rootminusone.omdbapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDataDao {

    @Query("SELECT * FROM MovieData")
    fun getAllMovies() : LiveData<List<MovieData>>

    @Query("SELECT * FROM MovieData where imdbID=:id")
    fun getMovieById(id : String) : LiveData<MovieData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieData: MovieData)

    @Delete
    fun deleteFavMovie(movieData: MovieData)

    @Query("DELETE FROM MovieData WHERE imdbID =:id")
    fun deleteMovieById(id: String)

}