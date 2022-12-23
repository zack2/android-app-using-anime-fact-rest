package com.olivierloukombo.android_app_using_anime_fact_rest.model

import android.net.Uri
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.Gson


@Parcelize
class Anime(
    val id: Long,
    val name: String,
    val release: String,
    val playtime: String,
    val description: String,
    val plot: String,
    val poster: String,
    val gif: String
): Parcelable{
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}