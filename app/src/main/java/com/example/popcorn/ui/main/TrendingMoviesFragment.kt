package com.example.popcorn.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.popcorn.R

class TrendingMoviesFragment(
    moviesUseCase: MoviesUseCase
) : Fragment() {

    private val trendingMoviesViewModel: TrendingMoviesViewModel by viewModels {
        TrendingMoviesViewModelFactory(this, moviesUseCase)
    }

    companion object {
        fun newInstance(moviesUseCase: MoviesUseCase) = TrendingMoviesFragment(moviesUseCase)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.trending_movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(trendingMoviesViewModel) {
            postTrendingMovies()
            trendingMoviesLiveData.observe(viewLifecycleOwner) {
                Log.i("Response", it.body().toString())
            }
        }
    }
}

class TrendingMoviesViewModelFactory(
    owner: SavedStateRegistryOwner,
    private val moviesUseCase: MoviesUseCase,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String, modelClass: Class<T>, handle: SavedStateHandle
    ): T {
        return TrendingMoviesViewModel(moviesUseCase) as T
    }
}