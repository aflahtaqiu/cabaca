package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class Genres (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("icon_url") val icon_url : String,
	@SerializedName("count") val count : Int,
	@SerializedName("is_primary") val is_primary : Int
)