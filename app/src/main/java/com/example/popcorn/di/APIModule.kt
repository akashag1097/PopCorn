package com.example.popcorn.di

import com.example.popcorn.GenreAdapter
import com.example.popcorn.MoviesAPI
import com.example.popcorn.ui.main.MovieUseCaseImpl
import com.example.popcorn.ui.main.MoviesRepo
import com.example.popcorn.ui.main.MoviesRepoImpl
import com.example.popcorn.ui.main.MoviesUseCase
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val MOVIE_DB_BASE_URL = "https://api.themoviedb.org/3/"

@Module
class NetworkModule {

    @Provides
    fun providesMoshiConvertor(): MoshiConverterFactory {
        val moshi = Moshi.Builder().add(GenreAdapter()).build()
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    fun provideMoviesRetrofitService(
        moshiConverterFactory: MoshiConverterFactory
    ) = Retrofit.Builder()
        .baseUrl(MOVIE_DB_BASE_URL)
        .addConverterFactory(moshiConverterFactory)
        .build()
        .create(MoviesAPI::class.java)

    @Provides
    fun providesMoviesRepo(
        moviesAPI: MoviesAPI
    ): MoviesRepo {
        return MoviesRepoImpl(moviesAPI)
    }

    @Provides
    fun providesMoviesUseCase(
        moviesRepo: MoviesRepo
    ): MoviesUseCase {
        return MovieUseCaseImpl(
            moviesRepo
        )
    }

}
