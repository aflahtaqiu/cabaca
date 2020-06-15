package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class RelatedByBook (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("cover_url") val cover_url : String
)