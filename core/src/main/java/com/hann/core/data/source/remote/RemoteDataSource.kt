package com.hann.core.data.source.remote

import android.util.Log
import com.hann.core.data.Resource
import com.hann.core.data.source.remote.network.ApiResponse
import com.hann.core.data.source.remote.network.ApiService
import com.hann.core.data.source.remote.response.GameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource constructor(private val apiService: ApiService) {

    suspend fun getAllGame(): Flow<ApiResponse<List<GameResponse>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote Data Source", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


}
