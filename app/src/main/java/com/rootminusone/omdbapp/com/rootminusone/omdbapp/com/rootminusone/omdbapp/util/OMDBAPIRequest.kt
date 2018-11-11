package com.rootminusone.omdbapp.com.rootminusone.omdbapp.com.rootminusone.omdbapp.util

import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBAPIRequest {

    @GET("?apikey=90ead5e6&type=movie")
    fun getMovieList(@Query("t") searchString: String) : Call<MovieResponse>

    companion object {

        fun create() : OMDBAPIRequest {
            val baseURL = "http://www.omdbapi.com/"
            val retrofit = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(MoshiConverterFactory.create()).build()

            return retrofit.create(OMDBAPIRequest::class.java)
        }
    }
}
