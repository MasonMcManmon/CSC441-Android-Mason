package edu.lemoyne.campusapp

import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

class ShowcaseRespository (private val api: ShowcaseApi = ShowcaseService.api) {
    suspend fun loadItems(): List<ShowcaseItem> =
        withContext(Dispatchers.IO) {
            api.getShowcaseItems( ShowcaseService.API_KEY)
        }
}