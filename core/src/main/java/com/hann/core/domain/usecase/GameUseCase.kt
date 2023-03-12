package com.hann.core.domain.usecase

import com.hann.core.data.Resource
import com.hann.core.domain.model.Game
import com.hann.core.domain.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGame(): Flow<Resource<List<Game>>>
    fun getFavoriteGame(): Flow<List<Game>>
    fun setFavoriteGame(game: Game, state: Boolean)
    fun getGameById(gameId : String) : Flow<Resource<GameDetail>>
}