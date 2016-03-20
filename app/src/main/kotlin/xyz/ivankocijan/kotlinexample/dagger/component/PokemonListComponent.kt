package xyz.ivankocijan.kotlinexample.dagger.component

import dagger.Subcomponent
import xyz.ivankocijan.kotlinexample.activities.PokemonListActivity
import xyz.ivankocijan.kotlinexample.dagger.module.PokemonListModule

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Subcomponent (modules = arrayOf(PokemonListModule::class))
interface PokemonListComponent {

    fun inject(pokemonListActivity: PokemonListActivity)

}