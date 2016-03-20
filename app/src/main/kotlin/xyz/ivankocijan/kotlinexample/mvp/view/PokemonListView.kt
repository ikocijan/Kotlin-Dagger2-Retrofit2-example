package xyz.ivankocijan.kotlinexample.mvp.view

import xyz.ivankocijan.kotlinexample.Pokemon

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
interface PokemonListView : BaseView {

    fun showPokemonList(listItem: List<Pokemon>)

}