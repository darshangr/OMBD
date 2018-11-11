package com.rootminusone.omdbapp.com.rootminusone.omdbapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieData")
data class MovieData(@PrimaryKey @ColumnInfo(name = "imdbID") var imdbId: String,
                     @ColumnInfo(name = "Title") var title: String,
                     @ColumnInfo(name = "Year") var year: String,
                     @ColumnInfo(name = "Director") var director: String,
                     @ColumnInfo(name = "Plot") var plot: String,
                     @ColumnInfo(name = "Released") var released: String,
                     @ColumnInfo(name = "Runtime") var runTime: String,
                     @ColumnInfo(name = "Language") var language: String,
                     @ColumnInfo(name = "Poster") var poster: String,
                     @ColumnInfo(name = "imdbRating") var imdbRating: String)

{



}