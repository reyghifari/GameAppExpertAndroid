package com.hann.core.data.source.remote.network

import com.hann.core.data.source.remote.response.GameDetailDto
import com.hann.core.data.source.remote.response.ListGameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/api/games?key=b73be3ee0ac445ec85a03fd34fd523c1")
    suspend fun getList(): ListGameResponse

    @GET("/api/games/{gameId}?key=b73be3ee0ac445ec85a03fd34fd523c1")
    suspend fun getGameById(
        @Path("gameId") gameId :String
    ) : GameDetailDto

}