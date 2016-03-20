package xyz.ivankocijan.kotlinexample.mvp.listener

import xyz.ivankocijan.kotlinexample.model.PokeDex

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
interface PokemonListListener : BaseListener {

    fun onSuccess(pokeDex: PokeDex)

}