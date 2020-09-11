package com.gads.practiceproject.feature.home.skillleaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gads.practiceproject.R
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import kotlinx.android.synthetic.main.fragment_learning_leaderboard.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SkillIqLeaderboardFragment : Fragment() {

    val viewModel: SkillIqLeaderboardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_skill_iq_leaderboard, container, false)
        observeData()
        viewModel.initData()
        return view
    }

    private fun observeData() {
        viewModel.leaders.observe(viewLifecycleOwner, Observer {
            it?.let { initLeadersRecycler(it) }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) loading_pb.visibility = View.VISIBLE
            else loading_pb.visibility = View.GONE
        })
    }

    private fun initLeadersRecycler(leaders: List<SkillIQLeaderModel>) {
        learning_leaders_rv.apply {
            adapter = SkillIQLeadersRecyclerAdapter(leaders)
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        const val TAG = "SKILL_LEADERS_TAG"
    }
}