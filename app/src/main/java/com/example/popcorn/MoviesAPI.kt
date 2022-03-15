package com.example.popcorn

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "799923e1d5b9c3c0b45d5815166f97fc"
interface MoviesAPI {

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(@Query("api_key") apiKey: String = API_KEY): Response<MoviesResponseDTO>

}