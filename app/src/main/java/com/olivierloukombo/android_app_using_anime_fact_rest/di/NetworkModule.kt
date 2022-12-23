package com.olivierloukombo.android_app_using_anime_fact_rest.di

import com.olivierloukombo.android_app_using_anime_fact_rest.network.ApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

import dagger.Provides

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiService.getInstance()
    }
}