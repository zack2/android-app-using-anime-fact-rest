package com.olivierloukombo.android_app_using_anime_fact_rest.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime
import com.olivierloukombo.android_app_using_anime_fact_rest.network.ApiService
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


class AnimeRepository @Inject constructor(private val api: ApiService) {
    private var animeListResponse: List<Anime> by mutableStateOf(listOf())
    private var error: String by mutableStateOf("")
    suspend fun getAnimes(): List<Anime>{
        coroutineScope {
            try {
                val animeList = api.getAnimes()
                animeListResponse = animeList
            }catch (e: Exception){
                error = e.message.toString()
            }
        }

        return animeListResponse;
    }
}