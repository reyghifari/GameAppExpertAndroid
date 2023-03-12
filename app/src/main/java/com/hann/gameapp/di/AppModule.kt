package com.hann.gameapp.di

import com.hann.core.domain.usecase.GameInteractor
import com.hann.core.domain.usecase.GameUseCase
import com.hann.gameapp.detail.DetailGameViewModel
import com.hann.gameapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> {
        GameInteractor(get())
    }

}

val viewModelModule = module {
    viewModel{
        HomeViewModel(get())
    }
    viewModel{
        DetailGameViewModel(get(), get())
    }
}