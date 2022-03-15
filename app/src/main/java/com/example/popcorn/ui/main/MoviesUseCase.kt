package com.example.popcorn.ui.main

import com.example.popcorn.MoviesResponseDTO
import retrofit2.Response
import javax.inject.Inject

interface MoviesUseCase {
    suspend fun getTrendingMovies(): Response<MoviesResponseDTO>
}

class MovieUseCaseImpl @Inject constructor(
    private val repo: MoviesRepo
) : MoviesUseCase {

    override suspend fun getTrendingMovies() = repo.getTrendingMovies()

}