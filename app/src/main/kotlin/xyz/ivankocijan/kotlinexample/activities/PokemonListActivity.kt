package xyz.ivankocijan.kotlinexample.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import xyz.ivankocijan.kotlinexample.Pokemon
import xyz.ivankocijan.kotlinexample.R
import xyz.ivankocijan.kotlinexample.adapter.PokemonAdapter
import xyz.ivankocijan.kotlinexample.dagger.module.PokemonListModule
import xyz.ivankocijan.kotlinexample.dagger.setup.component.AppComponent
import xyz.ivankocijan.kotlinexample.mvp.presenter.PokemonListPresenter
import xyz.ivankocijan.kotlinexample.mvp.view.PokemonListView
import java.util.*
import javax.inject.Inject

class PokemonListActivity : BaseActivity(), PokemonListView {

    val pokemonListRv: RecyclerView by bindView(R.id.recycler_pokemon_list)

    lateinit var pokemonAdapter: PokemonAdapter
    var pokemonList: List<Pokemon> = ArrayList()

    @Inject
    protected lateinit var presenter: PokemonListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.loadPokemonList()

    }


    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(PokemonListModule(this)).inject(this)
    }

    override fun getActivityLayout(): Int {
        return R.layout.activity_main;
    }

    override fun showPokemonList(listItems: List<Pokemon>) {
        pokemonListRv.layoutManager = LinearLayoutManager(this)
        pokemonAdapter = PokemonAdapter(listItems, this)
        pokemonListRv.adapter = pokemonAdapter
    }

    override fun onStop() {
        super.onStop()
        presenter.cancel()
    }
}
