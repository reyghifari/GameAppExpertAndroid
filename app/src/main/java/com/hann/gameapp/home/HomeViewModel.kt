package com.hann.gameapp.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hann.core.data.Resource
import com.hann.core.domain.model.Game
import com.hann.core.domain.usecase.GameUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeViewModel(private val gameUseCase: GameUseCase) : ViewModel() {

    val game = gameUseCase.getAllGame().asLiveData()

}