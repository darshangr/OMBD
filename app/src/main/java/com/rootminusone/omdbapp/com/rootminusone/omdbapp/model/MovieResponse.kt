package com.rootminusone.omdbapp.com.rootminusone.omdbapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.Year

@JsonClass(generateAdapter = true)
data class MovieResponse(@Json(name = "Title") var title:String? = "No Title", @Json(name = "Year") var year: String? = "", @Json(name = "Released") var released : String? = "", @Json(name = "Runtime") var runtime: String? = "",
                         @Json(name = "Director") var director:String? ="", @Json(name = "Plot") var plot:String? = "", @Json(name = "Language") var language : String? = "English", @Json(name = "Poster") var poster : String? = "",
                         @Json(name = "imdbRating") var rating : String? = "", @Json(name = "Production") var production:String? = "", @Json(name = "Response") var response :String? = "", @Json(name = "Error") var error : String ? = "") {
}