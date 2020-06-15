package id.aflah.cabaca.model.response

import com.google.gson.annotations.SerializedName
import id.aflah.cabaca.model.Writer

data class ResponseDetailWriter(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("result")
    val result: Writer
)