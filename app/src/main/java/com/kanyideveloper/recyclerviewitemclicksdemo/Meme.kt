package com.kanyideveloper.recyclerviewitemclicksdemo


import com.google.gson.annotations.SerializedName

data class Memes(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("success")
    val success: Boolean?
)

data class Data(
    @SerializedName("memes")
    val memes: List<Meme?>?
)

data class Meme(
    @SerializedName("box_count")
    val boxCount: Int?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)
