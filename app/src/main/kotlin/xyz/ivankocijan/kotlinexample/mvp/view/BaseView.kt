package xyz.ivankocijan.kotlinexample.mvp.view

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19/03/16
 */
interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showMessage(message: String = "There has been an error")

}