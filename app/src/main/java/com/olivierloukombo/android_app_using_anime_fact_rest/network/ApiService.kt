package com.olivierloukombo.android_app_using_anime_fact_rest.network
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("DisneyPosters2.json")
    suspend fun getAnimes(): List<Anime>


    companion object {
        private var api: ApiService? = null
        private const val BASE_URL: String = "https://gist.githubusercontent.com/skydoves/176c209dbce4a53c0ff9589e07255f30/raw/6489d9712702e093c4df71500fb822f0d408ef75/"
        private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        private val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        fun getInstance(): ApiService {
            if (api == null) {
                api = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                   // .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return api!!
        }
    }
}