package id.aflah.cabaca.model.response

import com.google.gson.annotations.SerializedName
import id.aflah.cabaca.model.Book

data class ResponseDetailBook(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("result")
    val result: Book
)