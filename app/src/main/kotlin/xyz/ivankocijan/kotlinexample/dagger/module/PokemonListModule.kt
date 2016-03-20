package xyz.ivankocijan.kotlinexample.dagger.module

import dagger.Module
import dagger.Provides
import xyz.ivankocijan.kotlinexample.mvp.interactor.PokemonListInteractor
import xyz.ivankocijan.kotlinexample.mvp.interactor.impl.PokemonListInteractorImpl
import xyz.ivankocijan.kotlinexample.mvp.presenter.PokemonListPresenter
import xyz.ivankocijan.kotlinexample.mvp.presenter.impl.PokemonListPresenterImpl
import xyz.ivankocijan.kotlinexample.mvp.view.PokemonListView

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Module
class PokemonListModule {

    val pokemonListView: PokemonListView

    constructor(pokemonListView: PokemonListView) {
        this.pokemonListView = pokemonListView
    }

    @Provides
    fun provideView(): PokemonListView = pokemonListView

    @Provides
    fun providePresenter(pokemonListPresenter: PokemonListPresenterImpl): PokemonListPresenter = pokemonListPresenter

    @Provides
    fun provideInteractor(pokemonListInteractor: PokemonListInteractorImpl): PokemonListInteractor = pokemonListInteractor

}