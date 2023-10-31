package co.nimblehq.kmm.template.di.modules

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import co.nimblehq.kmm.template.domain.usecases.UseCaseImpl
import co.nimblehq.kmm.template.domain.usecases.UseCase
import org.koin.dsl.bind

val useCaseModule = module {
    singleOf(::UseCaseImpl) bind UseCase::class
}
