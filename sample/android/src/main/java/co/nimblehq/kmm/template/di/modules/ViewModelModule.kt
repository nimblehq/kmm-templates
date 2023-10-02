package co.nimblehq.kmm.template.di.modules

import co.nimblehq.kmm.template.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}
