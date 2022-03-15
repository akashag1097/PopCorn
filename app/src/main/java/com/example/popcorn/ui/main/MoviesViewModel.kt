package com.example.popcorn.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviesViewModel : ViewModel() {
    private val _moviesLiveData = MutableLiveData<Int>()
    val moviesLiveData: LiveData<Int> = _moviesLiveData


}