package xyz.ivankocijan.kotlinexample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import xyz.ivankocijan.kotlinexample.Pokemon
import xyz.ivankocijan.kotlinexample.R
import xyz.ivankocijan.kotlinexample.extensions.id

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
class PokemonAdapter(val listItems: List<Pokemon>, val contex: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val pokemon: Pokemon = listItems[position]
        holder?.name?.text = pokemon.name
        holder?.pokemonId?.text = "#" + pokemon.id()

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        return ViewHolder(LayoutInflater.from(contex).inflate(R.layout.list_item_pokemon, parent, false));
    }

    override fun getItemCount(): Int {
        return listItems.size
    }


    class ViewHolder(internal var rootView: View) : RecyclerView.ViewHolder(rootView) {

        val name: TextView by bindView(R.id.pokemon_name)

        val pokemonId: TextView by bindView(R.id.pokemon_id)

    }
}