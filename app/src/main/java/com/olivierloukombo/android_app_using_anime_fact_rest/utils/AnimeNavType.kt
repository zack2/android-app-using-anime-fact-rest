package com.olivierloukombo.android_app_using_anime_fact_rest.utils

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime

@Suppress("DEPRECATION")
class AnimeNavType : NavType<Anime>(isNullableAllowed = false){
    override fun get(bundle: Bundle, key: String): Anime? {
        if(Build.VERSION.SDK_INT > 32)
            return bundle.getParcelable("anime", Anime::class.java)
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Anime {
        return Gson().fromJson(value, Anime::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Anime) {
        bundle.putParcelable(key, value)
    }

}