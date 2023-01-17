package com.hann.core.data

import com.hann.core.data.NetworkBoundResource
import com.hann.core.data.source.local.LocalDataSource
import com.hann.core.data.source.remote.RemoteDataSource
import com.hann.core.data.source.remote.network.ApiResponse
import com.hann.core.data.source.remote.response.GameResponse
import com.hann.core.domain.model.Game
import com.hann.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameSearchBoundResource constructor(
    private val query: String,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : NetworkBoundResource<List<Game>, List<GameResponse>>() {

    override fun loadFromDB(): Flow<List<Game>> {
        return localDataSource.getGames(query).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun shouldFetch(data: List<Game>?): Boolean {
        return data == null || data.isEmpty()
    }

    override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> {
        return remoteDataSource.getGame(query)
    }

    override suspend fun saveCallResult(data: List<GameResponse>) {
        val gameList = DataMapper.mapResponsesToEntities(data)
        localDataSource.insertGame(gameList)
    }
}