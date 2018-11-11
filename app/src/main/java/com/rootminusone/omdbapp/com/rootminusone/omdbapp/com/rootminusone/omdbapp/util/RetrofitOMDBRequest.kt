package com.rootminusone.omdbapp.com.rootminusone.omdbapp.com.rootminusone.omdbapp.util

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitOMDBRequest {

    val baseURL = "http://www.omdbapi.com/?apikey=90ead5e6&type=movie"
    val retrofit  = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build()

}