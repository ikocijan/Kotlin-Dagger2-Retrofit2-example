package xyz.ivankocijan.kotlinexample.model

import com.google.gson.annotations.SerializedName
import xyz.ivankocijan.kotlinexample.Pokemon

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
data class PokeDex(@SerializedName("pokemon") val pokemonList: List<Pokemon>)