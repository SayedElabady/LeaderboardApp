package com.gads.practiceproject.shared

import android.app.Application
import com.gads.practiceproject.shared.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    baseNetworkModule,
                    viewModelsModule,
                    sourcesModule,
                    reposModule,
                    formsNetworkModule
                )
            )
        }
    }

}