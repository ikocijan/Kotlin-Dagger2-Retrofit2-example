package xyz.ivankocijan.kotlinexample.mvp.interactor

import xyz.ivankocijan.kotlinexample.mvp.listener.PokemonListListener

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
interface PokemonListInteractor : BaseInteractor {

    fun loadPokemonList(pokemonListListener: PokemonListListener)

}
