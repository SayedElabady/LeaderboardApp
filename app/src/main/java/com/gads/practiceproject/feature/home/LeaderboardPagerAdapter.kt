package com.gads.practiceproject.feature.home

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter


class LeaderboardPagerAdapter(
    fragmentManager: FragmentActivity,
    private val fragmentList: List<Fragment>
) : FragmentStateAdapter(fragmentManager) {
    private val titles = listOf("Learning Leaders", "Skill IQ Leaders")

    fun getTabTitle(position: Int): String {
        return titles[position]
    }

    override fun getItemCount(): Int =
        fragmentList.size


    override fun createFragment(position: Int): Fragment = fragmentList[position]

}