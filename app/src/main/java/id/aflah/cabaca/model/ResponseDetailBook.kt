package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class ResponseDetailBook(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("result")
    val result: Book
)