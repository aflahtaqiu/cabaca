package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class ReadingList(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("cover_url") val cover_url : String,
    @SerializedName("status") val status : String,
    @SerializedName("schedule_task") val schedule_task : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("writer_id") val writer_id : Int,
    @SerializedName("Writer_by_writer_id") val writer_by_writer_id : WriterByWriterId,
    @SerializedName("isNew") val isNew : Boolean,
    @SerializedName("view_count") val view_count : Int,
    @SerializedName("rate_sum") val rate_sum : Int
)