package com.gads.practiceproject.shared.di

import com.gads.practiceproject.feature.home.learningleaders.LearningLeaderboardViewModel
import com.gads.practiceproject.feature.home.skillleaders.SkillIqLeaderboardViewModel
import com.gads.practiceproject.feature.submit.SubmitViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        LearningLeaderboardViewModel(get())
    }
    viewModel {
        SkillIqLeaderboardViewModel(get())
    }
    viewModel {
        SubmitViewModel(get())
    }

}