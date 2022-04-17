package com.example.midterm_francis_adrian

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

private val TAB_GENRES_FIXED = listOf(
    R.string.API,
    R.string.DISPLAY
)

class MovieGenresPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        if(position == 0){
            return ApiFragment.newInstance(context.resources.getString(TAB_GENRES_FIXED[position]))
        }
        return DisplayFragment.newInstance(context.resources.getString(TAB_GENRES_FIXED[position]))
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_GENRES_FIXED[position])
    }

    override fun getCount(): Int {
        // Show total pages.
        return TAB_GENRES_FIXED.size
    }
}