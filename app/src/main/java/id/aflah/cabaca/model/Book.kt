package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class Book (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("synopsis") val synopsis : String,
	@SerializedName("cover_url") val cover_url : String,
	@SerializedName("status") val status : String,
	@SerializedName("writer_id") val writer_id : Int,
	@SerializedName("download") val download : String,
	@SerializedName("schedule_daily") val schedule_daily : Int,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("updated_at") val updated_at : String,
	@SerializedName("category") val category : String,
	@SerializedName("nominasi") val nominasi : String,
	@SerializedName("challenge_id") val challenge_id : String,
	@SerializedName("Writer_by_writer_id") val writerByWriter_id : WriterByWriterId,
	@SerializedName("daily") val daily : String,
	@SerializedName("is_contract_actived") val is_contract_actived : Boolean,
	@SerializedName("is_free") val is_free : Boolean,
	@SerializedName("schedule_task") val schedule_task : String,
	@SerializedName("isNew") val isNew : Boolean,
	@SerializedName("time_to_vote") val time_to_vote : Boolean,
	@SerializedName("vote_count") val vote_count : String,
	@SerializedName("voted") val voted : Boolean,
	@SerializedName("book_url") val book_url : String,
	@SerializedName("auto_buy_chapter") val auto_buy_chapter : Boolean,
	@SerializedName("chapter_paid_count") val chapter_paid_count : Int,
	@SerializedName("hashtags") val hashtags : List<Hashtags>,
	@SerializedName("full_price") val full_price : Int,
	@SerializedName("full_purchase") val full_purchase : Boolean,
	@SerializedName("url_landing") val url_landing : String,
	@SerializedName("desc") val desc : String,
	@SerializedName("genres") val genres : List<Genres>,
	@SerializedName("genre_id") val idGenre: Int,
	@SerializedName("Genre_by_genre_id") val genre: Genres,
	@SerializedName("Related_by_book") val related_byBook : List<RelatedByBook>,
	@SerializedName("is_update") val is_update : Boolean,
	@SerializedName("view_count") val view_count : Int,
	@SerializedName("User_review") val user_review : String,
	@SerializedName("average_rate") val average_rate : Int,
	@SerializedName("decimal_rate") val decimal_rate : Double,
	@SerializedName("rate_sum") val rate_sum : Double,
	@SerializedName("reviews") val reviews : List<String>,
	@SerializedName("happyhour") val happyhour : Boolean,
	@SerializedName("BookChapter_by_book_id") val bookChapter_byBookId : List<BookChapterByBookId>,
	@SerializedName("chapter_count") val chapter_count : Int,
	@SerializedName("full_purchased") val full_purchased : Boolean
)