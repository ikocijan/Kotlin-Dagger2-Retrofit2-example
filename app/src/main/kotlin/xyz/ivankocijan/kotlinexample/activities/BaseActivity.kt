package xyz.ivankocijan.kotlinexample.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import xyz.ivankocijan.kotlinexample.PokemonApplication
import xyz.ivankocijan.kotlinexample.R
import xyz.ivankocijan.kotlinexample.dagger.setup.component.AppComponent
import xyz.ivankocijan.kotlinexample.mvp.view.BaseView

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19/03/16
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    abstract fun getActivityLayout(): Int

    abstract fun injectDependencies(appComponent : AppComponent)

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayout())
        injectDependencies(PokemonApplication.appComponent)
        initProgressDialog()

    }

    private fun initProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog?.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog?.setMessage(getString(R.string.please_wait))
    }

    override fun showProgress() {
        progressDialog?.show();
    }

    override fun hideProgress() {
        progressDialog?.hide();
    }

    override fun showMessage(message: String) {


    }
}