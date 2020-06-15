package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class UserByUserId (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("username") val username : String,
	@SerializedName("photo_url") val photo_url : String
)