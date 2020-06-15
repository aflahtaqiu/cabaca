package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class ResponseGenre(
    @SerializedName("resource")
    val resource: List<Genres>
) {
}