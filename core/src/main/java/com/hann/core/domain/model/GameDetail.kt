package com.hann.core.domain.model

data class GameDetail(
    val background_image: String,
    val description: String,
    val id: Int,
    val name: String,
    val playtime: Int,
    val rating: Double,
)