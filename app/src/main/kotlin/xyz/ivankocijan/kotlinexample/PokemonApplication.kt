package xyz.ivankocijan.kotlinexample

import android.app.Application
import timber.log.Timber
import xyz.ivankocijan.kotlinexample.dagger.setup.component.AppComponent
import xyz.ivankocijan.kotlinexample.dagger.setup.component.DaggerAppComponent

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
class PokemonApplication : Application () {

    companion object {
        @JvmStatic lateinit var instance: PokemonApplication
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        instance = this
        setupMainComponent();


    }

    private fun setupMainComponent() {
        appComponent = DaggerAppComponent.create();
        //        appComponent = DaggerAppComponent.create()
    }
}