package xyz.ivankocijan.kotlinexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import xyz.ivankocijan.kotlinexample.model.PokeDex

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
interface PokemonService {

    @GET("/api/v1/pokedex/1") fun getPokedex(): Call<PokeDex>

    @GET("/{resource_uri}") fun getPokemon(@Path("resource_uri") resourceUri: String): Call<Pokemon>

}