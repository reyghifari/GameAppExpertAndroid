package com.hann.core.data

import com.hann.core.data.source.local.LocalDataSource
import com.hann.core.data.source.remote.RemoteDataSource
import com.hann.core.data.source.remote.network.ApiResponse
import com.hann.core.data.source.remote.network.ApiService
import com.hann.core.data.source.remote.response.GameDetailDto
import com.hann.core.data.source.remote.response.GameResponse
import com.hann.core.domain.model.Game
import com.hann.core.domain.model.GameDetail
import com.hann.core.domain.repository.IGameRepository
import com.hann.core.utils.AppExecutors
import com.hann.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
    private val apiService: ApiService
): IGameRepository {

    override fun getAllGame(): Flow<com.hann.core.data.Resource<List<Game>>> =
        object : com.hann.core.data.NetworkBoundResource<List<Game>, List<GameResponse>>(){
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> =
                remoteDataSource.getAllGame()

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val gameList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(gameList)
            }
        }.asFlow()


    override fun getFavoriteGame(): Flow<List<Game>> {
        return localDataSource.getFavoriteGame().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override suspend fun getGame(gameId: String): GameDetailDto {
        return apiService.getGameById(gameId)
    }


    override fun setFavoriteGame(game: Game, state: Boolean) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(gameEntity, state) }
    }
}