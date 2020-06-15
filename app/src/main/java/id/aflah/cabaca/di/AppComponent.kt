package id.aflah.cabaca.di

import dagger.Component
import id.aflah.cabaca.data.CabacaRemoteRepository
import id.aflah.cabaca.ui.detailbook.DetailBookFragment
import id.aflah.cabaca.ui.detailbook.DetailBookViewModel
import id.aflah.cabaca.ui.detailwriter.DetailWriterFragment
import id.aflah.cabaca.ui.detailwriter.DetailWriterViewModel
import id.aflah.cabaca.ui.genre.GenreFragment
import id.aflah.cabaca.ui.genre.GenreViewModel
import id.aflah.cabaca.ui.newbook.NewBookFragment
import id.aflah.cabaca.ui.newbook.NewBookViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(target: GenreFragment)
    fun inject(target: GenreViewModel)

    fun inject(target: NewBookFragment)
    fun inject(target: NewBookViewModel)

    fun inject(target: DetailWriterFragment)
    fun inject(target: DetailWriterViewModel)

    fun inject(target: DetailBookFragment)
    fun inject(target: DetailBookViewModel)

    fun inject(target: CabacaRemoteRepository)
}