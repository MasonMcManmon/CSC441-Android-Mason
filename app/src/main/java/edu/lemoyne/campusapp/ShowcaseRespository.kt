package edu.lemoyne.campusapp

import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

class ShowcaseRespository(private val api: ShowcaseApi = ShowcaseService.api) {
    suspend fun loadItems(token: String): List<ShowcaseItem> =
        withContext(Dispatchers.IO) {
            api.getShowcaseItems(ShowcaseService.API_KEY, authorization = "Bearer $token")
        }

    suspend fun signIn(email: String, password: String): String =
        withContext(Dispatchers.IO) {
            api.signIn(
                apikey = ShowcaseService.API_KEY,
                request = LoginRequest(email, password)
            ).accessToken
        }
}