package id.aflah.cabaca.model

import com.google.gson.annotations.SerializedName

data class Writer(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("username") val username : String,
    @SerializedName("photo_url") val photo_url : String,
    @SerializedName("email") val email : String,
    @SerializedName("phone") val phone : String,
    @SerializedName("link_user") val link_user : String,
    @SerializedName("coin") val coin : Int,
    @SerializedName("deskripsi") val deskripsi : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("birthday") val birthday : String,
    @SerializedName("karya") val listKarya : List<Karya>,
    @SerializedName("current_level") val current_level : Int,
    @SerializedName("count_follower") val count_follower : Int,
    @SerializedName("count_following") val count_following : Int,
    @SerializedName("is_following") val is_following : Boolean,
    @SerializedName("following_user") val following_user : List<String>,
    @SerializedName("reading_list") val reading_list : List<ReadingList>
)