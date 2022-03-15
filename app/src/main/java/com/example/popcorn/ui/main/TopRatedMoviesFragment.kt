package com.example.popcorn.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popcorn.R

class TopRatedMoviesFragment : Fragment() {

    companion object {
        fun newInstance() = TopRatedMoviesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_rated_movies_fragment, container, false)
    }
}