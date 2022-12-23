package com.olivierloukombo.android_app_using_anime_fact_rest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) :
    ViewModel() {
    //private lateinit var  anime: Anime
    private val _secondsRemaining = savedStateHandle.getLiveData<Anime>("anime")
    private val animeLiveData: LiveData<Anime> get() = _secondsRemaining
    private val anime = animeLiveData.value

    fun getDetailAnime() = anime
}