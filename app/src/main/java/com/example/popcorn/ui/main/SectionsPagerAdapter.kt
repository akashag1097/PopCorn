package com.example.popcorn.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.popcorn.R

private const val TRENDING_POSITION = 0
private const val LATEST_POSITION = 1

private val TAB_TITLES = arrayOf(
        R.string.tab_trending,
        R.string.tab_latest,
        R.string.tab_topRated
)

class SectionsPagerAdapter(
    private val context: Context,
    fm: FragmentManager,
    private val moviesUseCase: MoviesUseCase
)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            TRENDING_POSITION -> TrendingMoviesFragment.newInstance(moviesUseCase)
            LATEST_POSITION -> LatestMoviesFragment.newInstance()
            else -> TopRatedMoviesFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }
}