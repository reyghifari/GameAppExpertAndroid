package com.hann.core.utils

import com.hann.core.data.source.local.entity.GameEntity
import com.hann.core.data.source.remote.response.GameResponse
import com.hann.core.domain.model.Game
import com.hann.core.domain.model.GameDetail

object DataMapper {
    fun mapResponsesToEntities(input: List<GameResponse>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                gameId = it.id,
                name = it.name,
                released = it.released,
                rating = it.rating,
                background_image = it.background_image,
                playtime = it.playtime,
                isFavorite = false
            )
            gameList.add(game)
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                name = it.name,
                released = it.released,
                rating = it.rating,
                background_image = it.background_image,
                playtime = it.playtime,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        gameId = input.gameId,
        name = input.name,
        released = input.released,
        rating = input.rating,
        background_image = input.background_image,
        playtime = input.playtime,
        isFavorite = input.isFavorite
    )
}