package com.gads.practiceproject.shared.store.remote

import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import io.reactivex.Single

class LeaderboardAPI(private val service: ILeaderboardService) : ILeaderboardAPI {
    override fun getLearningLeaders(): Single<List<LearningLeaderModel>> {
        return service.getLearningLeaders()
    }

    override fun getSkillLeaders(): Single<List<SkillIQLeaderModel>> = service.getSkillLeaders()

}