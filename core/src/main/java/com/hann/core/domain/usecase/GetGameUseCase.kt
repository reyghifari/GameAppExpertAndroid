package com.hann.core.domain.usecase

import com.hann.core.data.GameRepository
import com.hann.core.data.Resource
import com.hann.core.data.source.remote.response.toGameDetail
import com.hann.core.domain.model.GameDetail
import com.hann.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetGameUseCase constructor(
    private val repository: IGameRepository
) {

    operator fun invoke(gameId: String) : Flow<Resource<GameDetail>> = flow {
        try {
            emit(Resource.Loading<GameDetail>())
            val game = repository.getGame(gameId).toGameDetail()
            emit(Resource.Success<GameDetail>(game))
        }catch (e: HttpException){
            emit(Resource.Error<GameDetail>(e.localizedMessage ?: "An unexpected Error Occured"))
        }catch (e: IOException){
            emit(Resource.Error<GameDetail>("Couldnt't reach server. Check your internet server"))
        }
    }

}