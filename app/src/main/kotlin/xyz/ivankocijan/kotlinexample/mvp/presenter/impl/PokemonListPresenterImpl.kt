package xyz.ivankocijan.kotlinexample.mvp.presenter.impl

import xyz.ivankocijan.kotlinexample.Pokemon
import xyz.ivankocijan.kotlinexample.extensions.id
import xyz.ivankocijan.kotlinexample.model.PokeDex
import xyz.ivankocijan.kotlinexample.mvp.interactor.PokemonListInteractor
import xyz.ivankocijan.kotlinexample.mvp.listener.PokemonListListener
import xyz.ivankocijan.kotlinexample.mvp.presenter.PokemonListPresenter
import xyz.ivankocijan.kotlinexample.mvp.view.PokemonListView
import java.util.*
import javax.inject.Inject

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
class PokemonListPresenterImpl : PokemonListPresenter {

    val pokemonListView: PokemonListView

    val pokemonListInteractor: PokemonListInteractor

    @Inject
    constructor(pokemonListView: PokemonListView, pokemonListInteractor: PokemonListInteractor) {
        this.pokemonListView = pokemonListView
        this.pokemonListInteractor = pokemonListInteractor
    }

    override fun loadPokemonList() {

        pokemonListView.showProgress()

        pokemonListInteractor.loadPokemonList(object : PokemonListListener {

            override fun onSuccess(pokeDex: PokeDex) {

                val pokemonList: List<Pokemon> = pokeDex.pokemonList

                Collections.sort(pokemonList) { x, y -> x.id() - y.id() }

                pokemonListView.showPokemonList(pokeDex.pokemonList)
                pokemonListView.hideProgress()
            }

            override fun onFailure(message: String) {
                pokemonListView.hideProgress()
                pokemonListView.showMessage(message)

            }
        })


    }

    override fun cancel() {
        pokemonListInteractor.cancel()
    }

}