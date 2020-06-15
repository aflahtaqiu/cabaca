package id.aflah.cabaca

import android.app.Application
import id.aflah.cabaca.di.AppComponent
import id.aflah.cabaca.di.AppModule
import id.aflah.cabaca.di.DaggerAppComponent

class CabacaApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = initDagger(this)
    }

    private fun initDagger(app: CabacaApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}