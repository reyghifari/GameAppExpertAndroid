package com.hann.core.domain.usecase

import com.hann.core.data.Resource
import com.hann.core.domain.model.Game
import com.hann.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow

class GameInteractor(private val gameRepository: IGameRepository) :GameUseCase {
    override fun getAllGame(): Flow<Resource<List<Game>>> {
       return gameRepository.getAllGame()
    }

    override fun getGame(query: String): Flow<Resource<List<Game>>> {
        return gameRepository.getGame(query)
    }

    override fun getFavoriteGame(): Flow<List<Game>> {
       return gameRepository.getFavoriteGame()
    }

    override fun setFavoriteGame(game: Game, state: Boolean) {
        return gameRepository.setFavoriteGame(game,state)
    }

}