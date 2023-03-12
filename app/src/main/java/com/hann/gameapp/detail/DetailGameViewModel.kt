package com.hann.gameapp.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hann.core.domain.model.Game
import com.hann.core.domain.usecase.GameUseCase
import com.hann.core.utils.Constants

class DetailGameViewModel(
    private val gameUseCase: GameUseCase,
    savedStateHandle: SavedStateHandle
    ) : ViewModel() {
    val gameDetail =
        savedStateHandle.get<String>(Constants.PARAM_GAME_ID)
            ?.let { gameUseCase.getGameById(it).asLiveData() }

    fun setGameFavorite(game: Game, newState: Boolean)= gameUseCase.setFavoriteGame(game, newState)


}