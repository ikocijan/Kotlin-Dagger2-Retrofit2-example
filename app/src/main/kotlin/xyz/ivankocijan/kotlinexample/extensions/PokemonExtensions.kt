package xyz.ivankocijan.kotlinexample.extensions

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import xyz.ivankocijan.kotlinexample.Pokemon

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */

fun Pokemon.id(): Int {

    try {
        val tokens = TextUtils.split(resourceUri, "/")
        val id =
                if (TextUtils.isEmpty(tokens[tokens.size - 1])) {
                    tokens[tokens.size - 2]
                } else {
                    tokens[tokens.size - 1]
                }
        return Integer.parseInt(id)
    } catch (e: Exception) {
        return 0
    }


}

fun Context.myToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}