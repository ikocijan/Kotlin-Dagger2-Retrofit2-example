package xyz.ivankocijan.kotlinexample.dagger.setup.component

import dagger.Component
import xyz.ivankocijan.kotlinexample.dagger.component.PokemonListComponent
import xyz.ivankocijan.kotlinexample.dagger.module.PokemonListModule
import xyz.ivankocijan.kotlinexample.dagger.setup.module.*
import javax.inject.Singleton

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Singleton
@Component(modules = arrayOf(
        AppContextModule::class,
        RetrofitModule::class,
        ClientModule::class,
        GsonConverterModule::class,
        GsonModule::class,
        HostModule::class,
        LoggerModule::class
))
interface AppComponent {

    fun plus(pokemonListModule: PokemonListModule): PokemonListComponent

}