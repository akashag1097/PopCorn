package com.example.popcorn.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popcorn.R

class LatestMoviesFragment : Fragment() {

    companion object {
        fun newInstance() = LatestMoviesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.latest_movies_fragment, container, false)
    }
}