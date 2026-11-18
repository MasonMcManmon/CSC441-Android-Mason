package edu.lemoyne.campusapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface ShowcaseApi {
    @GET("/rest/v1/showcase_items")
    suspend fun getShowcaseItems (
        @Header("apikey") apikey: String
    ): List<ShowcaseItem>
}

object ShowcaseService {
    const val API_KEY = "sb_publishable_G_XQi20PHDbGYQ-31mfqZw_8SnY1hW3"
    const val BASE_URL = "https://oqgbxfwxfpxfqvkamipz.supabase.co"

    val api: ShowcaseApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ShowcaseApi::class.java)
}