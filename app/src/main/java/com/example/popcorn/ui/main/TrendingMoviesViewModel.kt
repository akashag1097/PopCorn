package com.example.popcorn.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popcorn.MoviesResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class TrendingMoviesViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _trendingMoviesLiveData = MutableLiveData<Response<MoviesResponseDTO>>()
    val trendingMoviesLiveData: LiveData<Response<MoviesResponseDTO>> = _trendingMoviesLiveData

    fun postTrendingMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            _trendingMoviesLiveData.postValue(moviesUseCase.getTrendingMovies())
        }
    }
}