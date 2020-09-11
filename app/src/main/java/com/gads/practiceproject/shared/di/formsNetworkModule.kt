package com.gads.practiceproject.shared.di

import android.content.Context
import com.beat.androidtask.foddvenues.shared.store.remote.interceptors.JsonInterceptor
import com.gads.practiceproject.shared.Constants
import com.gads.practiceproject.shared.store.remote.CachePolicy
import com.gads.practiceproject.shared.store.remote.IGoogleFormsService
import com.gads.practiceproject.shared.store.remote.ILeaderboardService
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val formsNetworkModule = module {


    single<Retrofit>(named(Constants.FORMS_NETWORK_MODULE)) {
        val context: Context = get()
        val cachePolicy: CachePolicy = get()
        val gson: Gson = get()
        val jsonInterceptor: JsonInterceptor = get()
        val loggerInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val cacheSize = cachePolicy.provideCacheSize()
        val dir = context.cacheDir
        val cache = Cache(dir, cacheSize.toLong())

        val client = OkHttpClient.Builder()
            .addInterceptor(jsonInterceptor)
            .addInterceptor(loggerInterceptor)
            .cache(cache)
            .build()

        Retrofit.Builder()
            .baseUrl(Constants.FORMS_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    single<IGoogleFormsService> {
        val retrofit: Retrofit = get(named(Constants.FORMS_NETWORK_MODULE))

        retrofit.create(IGoogleFormsService::class.java)
    }
}