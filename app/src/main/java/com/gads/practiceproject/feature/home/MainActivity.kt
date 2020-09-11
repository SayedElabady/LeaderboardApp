package com.gads.practiceproject.feature.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gads.practiceproject.R
import com.gads.practiceproject.feature.home.learningleaders.LearningLeaderboardFragment
import com.gads.practiceproject.feature.home.skillleaders.SkillIqLeaderboardFragment
import com.gads.practiceproject.feature.submit.SubmitActivity
import com.gads.practiceproject.shared.store.ui.hideNavigationBarKeepStatus
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val adapterViewPager = LeaderboardPagerAdapter(
            this,
            listOf(LearningLeaderboardFragment(), SkillIqLeaderboardFragment())
        )
        viewPager.adapter = adapterViewPager
        TabLayoutMediator(tabLayout, viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = adapterViewPager.getTabTitle(position)
            }).attach()
        submit_btn.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
    }
}