package com.example.popcorn.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popcorn.MoviesResponseDTO

class LatestMoviesViewModel : ViewModel() {

    private val _latestMoviesLiveData = MutableLiveData<MoviesResponseDTO>()
    val latestMoviesLiveData: LiveData<MoviesResponseDTO> = _latestMoviesLiveData

}