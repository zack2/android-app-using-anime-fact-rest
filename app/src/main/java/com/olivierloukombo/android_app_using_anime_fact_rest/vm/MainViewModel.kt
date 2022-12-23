package com.olivierloukombo.android_app_using_anime_fact_rest.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime
import com.olivierloukombo.android_app_using_anime_fact_rest.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    private var commentListResponse: List<Anime> by mutableStateOf(listOf())

    fun getAnimes(): List<Anime> {
        viewModelScope.launch {
            val comments = repository.getAnimes()
            commentListResponse = comments
        }
        return commentListResponse
    }
}
