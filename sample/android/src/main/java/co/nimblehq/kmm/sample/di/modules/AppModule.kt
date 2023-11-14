package co.nimblehq.kmm.sample.di.modules

import co.nimblehq.kmm.sample.util.DispatchersProvider
import co.nimblehq.kmm.sample.util.DispatchersProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::DispatchersProviderImpl) bind DispatchersProvider::class

}
