package co.nimblehq.kmm.template.di.module

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import co.nimblehq.kmm.template.domain.usecases.GetUsersUseCaseImpl
import co.nimblehq.kmm.template.domain.usecases.GetUsersUseCase
import org.koin.dsl.bind

val useCaseModule = module {
    singleOf(::GetUsersUseCaseImpl) bind GetUsersUseCase::class
}
