package id.aflah.cabaca.model.response

import com.google.gson.annotations.SerializedName
import id.aflah.cabaca.model.Book

data class ResponseBooks(
    val success: Boolean,

    val result: List<Book>

)