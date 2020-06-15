package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName


data class BookChapterByBookId (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("chapter_sequence") val chapter_sequence : Int,
	@SerializedName("price") val price : Int,
	@SerializedName("is_warning") val is_warning : String,
	@SerializedName("book_id") val book_id : Int,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("schedule_task") val schedule_task : String,
	@SerializedName("new") val new : Boolean,
	@SerializedName("is_purchased") val is_purchased : Boolean,
	@SerializedName("view_count") val view_count : Int,
	@SerializedName("view_by_user") val view_by_user : Int,
	@SerializedName("like_count") val like_count : Int,
	@SerializedName("is_readed") val is_readed : Boolean
)