package id.aflah.cabaca.data

import id.aflah.cabaca.model.ResponseDetailBook
import id.aflah.cabaca.model.ResponseGenre
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiEndpoint {
    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("cabaca/_table/genre")
    suspend fun getGenres(
    ): ResponseGenre
}