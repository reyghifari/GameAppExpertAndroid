package com.hann.gameapp.detail

import androidx.lifecycle.ViewModel
import com.hann.core.domain.model.Game
import com.hann.core.domain.usecase.GameUseCase

class DetailGameViewModel(private val gameUseCase: GameUseCase) : ViewModel() {

    fun setGameFavorite(game: Game, newState: Boolean)= gameUseCase.setFavoriteGame(game, newState)


}