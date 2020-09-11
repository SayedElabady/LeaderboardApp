package com.gads.practiceproject.shared.store.remote

import com.gads.practiceproject.shared.Constants
import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import io.reactivex.Single
import retrofit2.http.GET

interface ILeaderboardAPI{

    fun getLearningLeaders(): Single<List<LearningLeaderModel>>

    fun getSkillLeaders(): Single<List<SkillIQLeaderModel>>

}