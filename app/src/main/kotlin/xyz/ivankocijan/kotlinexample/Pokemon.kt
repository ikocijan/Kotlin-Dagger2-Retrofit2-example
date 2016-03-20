package xyz.ivankocijan.kotlinexample

import com.google.gson.annotations.SerializedName

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
data class Pokemon(@SerializedName("name") val name: String,
                   @SerializedName("resource_uri") val resourceUri: String,
                   @SerializedName("hp") val hp: String,
                   @SerializedName("attack") val attack: String,
                   @SerializedName("defense") val defense: String,
                   @SerializedName("height") val height: String,
                   @SerializedName("weight") val weight: String) {

}