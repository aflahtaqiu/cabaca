package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class Hashtags (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String
)