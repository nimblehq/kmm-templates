package co.nimblehq.kmm.template.di.modules

import co.nimblehq.kmm.template.BuildConfig
import co.nimblehq.kmm.template.data.di.modules.BASE_API_URL
import co.nimblehq.kmm.template.util.DispatchersProvider
import co.nimblehq.kmm.template.util.DispatchersProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::DispatchersProviderImpl) bind DispatchersProvider::class

    single(named(BASE_API_URL)) {
        BuildConfig.BASE_API_URL
    }
}
