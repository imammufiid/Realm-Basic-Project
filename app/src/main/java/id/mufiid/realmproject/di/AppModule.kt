package id.mufiid.realmproject.di

import id.mufiid.realmproject.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { MainViewModel(get()) }
}