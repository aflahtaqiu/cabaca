package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class Karya (
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("writer_id") val writer_id : Int,
    @SerializedName("cover_url") val cover_url : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("schedule_task") val schedule_task : String,
    @SerializedName("status") val status : String,
    @SerializedName("isNew") val isNew : Boolean,
    @SerializedName("rate_sum") val rate_sum : Double,
    @SerializedName("view_count") val view_count : Int,
    @SerializedName("is_update") val is_update : Boolean,
    @SerializedName("Writer_by_writer_id") val writer_by_writer_id : WriterByWriterId,
    @SerializedName("bab_count") val bab_count : Int,
    @SerializedName("chapter_count") val chapter_count : Int
)