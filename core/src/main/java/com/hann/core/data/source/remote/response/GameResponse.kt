package com.hann.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("playtime")
    val playtime: String,

    @field:SerializedName("background_image")
    val background_image: String
)