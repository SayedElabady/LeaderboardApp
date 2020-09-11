package com.gads.practiceproject.shared.store.repository

import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import io.reactivex.Single

interface ILeaderRepository {

    fun getLearningLeaders(): Single<List<LearningLeaderModel>>

    fun getSkillLeaders(): Single<List<SkillIQLeaderModel>>

}