package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class WriterByWriterId (

	@SerializedName("id") val id : Int,
	@SerializedName("user_id") val user_id : Int,
	@SerializedName("status") val status : String,
	@SerializedName("type") val type: String,
	@SerializedName("User_by_user_id") val userByUser_id : UserByUserId
)