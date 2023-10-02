package co.nimblehq.kmm.template.di.modules

import co.nimblehq.kmm.template.util.DispatchersProvider
import co.nimblehq.kmm.template.util.DispatchersProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::DispatchersProviderImpl) bind DispatchersProvider::class

}
