package com.olivierloukombo.android_app_using_anime_fact_rest.di

import com.olivierloukombo.android_app_using_anime_fact_rest.network.ApiService
import com.olivierloukombo.android_app_using_anime_fact_rest.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideListUserRepository(apiService: ApiService): AnimeRepository {
        return AnimeRepository(apiService)
    }

}