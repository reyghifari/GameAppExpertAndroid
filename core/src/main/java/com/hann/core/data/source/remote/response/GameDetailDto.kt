package com.hann.core.data.source.remote.response

import com.hann.core.domain.model.GameDetail

data class GameDetailDto(
    val background_image: String,
    val creators_count: Int,
    val description: String,
    val id: Int,
    val name: String,
    val playtime: Int,
    val rating: Double,
)

fun GameDetailDto.toGameDetail() : GameDetail {
    return GameDetail(
        background_image = background_image,
        description = description,
        id = id,
        name = name,
        playtime = playtime,
        rating = rating,
    )
}

