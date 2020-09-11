package com.gads.practiceproject.shared.store.repository

import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import com.gads.practiceproject.shared.store.remote.ILeaderboardAPI
import io.reactivex.Single

class LeaderRepository(private val leaderboardAPI: ILeaderboardAPI) : ILeaderRepository {
    override fun getLearningLeaders(): Single<List<LearningLeaderModel>> {
        return leaderboardAPI.getLearningLeaders()
    }

    override fun getSkillLeaders(): Single<List<SkillIQLeaderModel>> =
        leaderboardAPI.getSkillLeaders()

}