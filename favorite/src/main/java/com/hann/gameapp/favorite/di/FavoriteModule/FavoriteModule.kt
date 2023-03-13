package com.hann.gameapp.favorite.di.FavoriteModule

import com.hann.gameapp.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteviewModelModule = module {
    viewModel {
        FavoriteViewModel(get())
    }
}