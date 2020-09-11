package com.gads.practiceproject.feature.home.learningleaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gads.practiceproject.R
import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import kotlinx.android.synthetic.main.fragment_learning_leaderboard.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LearningLeaderboardFragment : Fragment() {

    val viewModel: LearningLeaderboardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_learning_leaderboard, container, false)
        observeData()
        viewModel.initData()
        return view
    }

    private fun observeData() {
        viewModel.leaders.observe(viewLifecycleOwner, Observer {
            it?.let { initLeadersRecycler(it) }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) loading_pb.visibility = VISIBLE
            else loading_pb.visibility = GONE
        })
    }

    private fun initLeadersRecycler(leaders: List<LearningLeaderModel>) {
        learning_leaders_rv.apply {
            adapter = LearningLeadersRecyclerAdapter(leaders)
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        const val TAG = "LEARNING_LEADERS_TAG"
    }


}