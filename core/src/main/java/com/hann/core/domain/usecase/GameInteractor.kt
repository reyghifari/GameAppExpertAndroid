package com.hann.core.domain.usecase

import com.hann.core.data.Resource
import com.hann.core.data.source.remote.response.toGameDetail
import com.hann.core.domain.model.Game
import com.hann.core.domain.model.GameDetail
import com.hann.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GameInteractor(private val gameRepository: IGameRepository) :GameUseCase {
    override fun getAllGame(): Flow<Resource<List<Game>>> {
       return gameRepository.getAllGame()
    }

    override fun getFavoriteGame(): Flow<List<Game>> {
       return gameRepository.getFavoriteGame()
    }

    override fun setFavoriteGame(game: Game, state: Boolean) {
        return gameRepository.setFavoriteGame(game,state)
    }

    override  fun getGameById(gameId: String): Flow<Resource<GameDetail>>  = flow<Resource<GameDetail>> {
        try {
            emit(Resource.Loading<GameDetail>())
            val game = gameRepository.getGame(gameId).toGameDetail()
            emit(Resource.Success<GameDetail>(game))
        }catch (e: HttpException){
            emit(Resource.Error<GameDetail>(e.localizedMessage ?: "An unexpected Error Occured"))
        }catch (e: IOException){
            emit(Resource.Error<GameDetail>("Couldnt't reach server. Check your internet server"))
        }
    }




}