package id.aflah.cabaca.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import id.aflah.cabaca.data.ApiEndpoint
import id.aflah.cabaca.data.CabacaRemoteRepository
import id.aflah.cabaca.ui.genre.GenreViewModel
import id.aflah.cabaca.ui.genre.GenresAdapter
import id.aflah.cabaca.ui.newbook.NewBookViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://cabaca.id:8443/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit) : ApiEndpoint = retrofit.create(ApiEndpoint::class.java)

    @Provides
    @Singleton
    fun provideRemoteRepository (apiEndpoint: ApiEndpoint) =
        CabacaRemoteRepository(apiEndpoint)

    @Provides
    @Singleton
    fun provideGenreViewModel(repository: CabacaRemoteRepository) = GenreViewModel(repository)

    @Provides
    @Singleton
    fun provideNewBookViewModel(repository: CabacaRemoteRepository) = NewBookViewModel(repository)

    @Provides
    @Singleton
    fun provideGenreAdapter() = GenresAdapter()
}