package co.nimblehq.kmm.sample.di.modules

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import co.nimblehq.kmm.sample.data.repositories.RepositoryImpl
import co.nimblehq.kmm.sample.domain.repositories.Repository
import org.koin.dsl.bind

val repositoryModule = module {
    singleOf(::RepositoryImpl) bind Repository::class
}
