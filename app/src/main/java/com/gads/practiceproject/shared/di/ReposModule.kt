package com.gads.practiceproject.shared.di


import com.gads.practiceproject.shared.store.repository.ILeaderRepository
import com.gads.practiceproject.shared.store.repository.ISubmissionRepository
import com.gads.practiceproject.shared.store.repository.LeaderRepository
import com.gads.practiceproject.shared.store.repository.SubmissionRepository
import org.koin.dsl.module

val reposModule = module {

    single<ILeaderRepository> { LeaderRepository(get()) }
    single<ISubmissionRepository> { SubmissionRepository(get()) }

}
