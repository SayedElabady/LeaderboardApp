package com.gads.practiceproject.shared.di

import com.gads.practiceproject.shared.store.remote.FormsAPI
import com.gads.practiceproject.shared.store.remote.IFormsAPI
import com.gads.practiceproject.shared.store.remote.ILeaderboardAPI
import com.gads.practiceproject.shared.store.remote.LeaderboardAPI
import org.koin.dsl.module

val sourcesModule = module {
    single<ILeaderboardAPI> {
        LeaderboardAPI(get())
    }
    single<IFormsAPI> {
        FormsAPI(get())
    }

}