package co.nimblehq.kmm.sample.di.modules

import co.nimblehq.kmm.sample.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}
