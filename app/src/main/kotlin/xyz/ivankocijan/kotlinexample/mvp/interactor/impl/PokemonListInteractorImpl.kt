package xyz.ivankocijan.kotlinexample.mvp.interactor.impl


import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import xyz.ivankocijan.kotlinexample.PokemonService
import xyz.ivankocijan.kotlinexample.R
import xyz.ivankocijan.kotlinexample.model.PokeDex
import xyz.ivankocijan.kotlinexample.mvp.interactor.PokemonListInteractor
import xyz.ivankocijan.kotlinexample.mvp.listener.PokemonListListener
import javax.inject.Inject

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
class PokemonListInteractorImpl : PokemonListInteractor {

    val retrofit: Retrofit

    val pokemonService: PokemonService

    val appContext: Context

    lateinit var call: Call<PokeDex>

    @Inject
    constructor(retrofit: Retrofit, pokemonService: PokemonService, appContext: Context) {
        this.retrofit = retrofit
        this.pokemonService = pokemonService
        this.appContext = appContext
    }


    override fun loadPokemonList(pokemonListListener: PokemonListListener) {


        call = pokemonService.getPokedex();
        call.enqueue(object : Callback<PokeDex> {
            override fun onResponse(call: Call<PokeDex>?, response: Response<PokeDex>?) {

                if (response != null && response.isSuccessful) {
                    pokemonListListener.onSuccess(response.body())
                } else {
                    pokemonListListener.onFailure(appContext.getString(R.string.error_fetching_data))
                }


            }

            override fun onFailure(call: Call<PokeDex>?, t: Throwable?) {
                pokemonListListener.onFailure(appContext.getString(R.string.error_fetching_data))
            }
        })


    }

    override fun cancel() {
        call.cancel()
    }

}