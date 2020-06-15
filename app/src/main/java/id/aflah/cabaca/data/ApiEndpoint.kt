package id.aflah.cabaca.data

import id.aflah.cabaca.model.response.ResponseBooks
import id.aflah.cabaca.model.ResponseGenre
import id.aflah.cabaca.model.response.ResponseDetailBook
import id.aflah.cabaca.model.response.ResponseDetailWriter
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import javax.annotation.Nullable

interface ApiEndpoint {

    //No 1
    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("cabaca/_table/genre")
    suspend fun getGenres(
    ): ResponseGenre

    //No 2
    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/category")
    suspend fun getBooksByCategory(
        @Query("id") idCategory:Int
    ): ResponseBooks

    //No 3
    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/uptodate")
    suspend fun getNewBooks(
        @Query("limit") limit:Int?
    ): ResponseBooks

    //No 4
    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/detail/{idBook}")
    suspend fun getDetailBook(
        @Path("idBook") idBook: Int
    ): ResponseDetailBook

    //No 4
    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("writer/detail/{idWriter}")
    suspend fun getDetailWriter(
        @Path("idWriter") idWriter: Int
    ): ResponseDetailWriter
}