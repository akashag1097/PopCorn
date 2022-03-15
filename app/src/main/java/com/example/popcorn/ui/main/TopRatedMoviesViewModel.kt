package com.example.popcorn.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popcorn.MoviesResponseDTO

class TopRatedMoviesViewModel : ViewModel() {

    private val _topRatedMoviesLiveData = MutableLiveData<MoviesResponseDTO>()
    val topRatedMoviesLiveData: LiveData<MoviesResponseDTO> = _topRatedMoviesLiveData



}