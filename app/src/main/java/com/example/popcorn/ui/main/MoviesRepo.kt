package com.example.popcorn.ui.main

import com.example.popcorn.MoviesAPI
import com.example.popcorn.MoviesResponseDTO
import retrofit2.Response
import javax.inject.Inject

interface MoviesRepo {
    suspend fun getTrendingMovies(): Response<MoviesResponseDTO>
}

class MoviesRepoImpl @Inject constructor(
    private val moviesService: MoviesAPI
) : MoviesRepo {

    override suspend fun getTrendingMovies(): Response<MoviesResponseDTO> {
        return moviesService.getTrendingMovies()
    }
}
