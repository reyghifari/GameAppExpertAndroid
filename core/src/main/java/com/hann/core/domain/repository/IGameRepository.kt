package com.hann.core.domain.repository

import com.hann.core.data.Resource
import com.hann.core.data.source.remote.response.GameDetailDto
import com.hann.core.domain.model.Game
import com.hann.core.domain.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface IGameRepository {
    fun getAllGame(): Flow<Resource<List<Game>>>

    fun getFavoriteGame(): Flow<List<Game>>

    suspend fun getGame(gameId: String) : GameDetailDto

    fun setFavoriteGame(game: Game, state: Boolean)
}