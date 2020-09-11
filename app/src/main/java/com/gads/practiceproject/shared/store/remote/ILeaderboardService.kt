package com.gads.practiceproject.shared.store.remote

import com.gads.practiceproject.shared.Constants
import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import io.reactivex.Single
import retrofit2.http.GET


interface ILeaderboardService {

    @GET(Constants.LEARNING_LEADER_URL)
    fun getLearningLeaders(): Single<List<LearningLeaderModel>>


    @GET(Constants.SKILL_IQ_LEADERS_URL)
    fun getSkillLeaders(): Single<List<SkillIQLeaderModel>>
}