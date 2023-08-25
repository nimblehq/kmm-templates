package co.nimblehq.kmm.template.di.module

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import co.nimblehq.kmm.template.data.repositories.RepositoryImpl
import co.nimblehq.kmm.template.domain.repositories.Repository
import org.koin.dsl.bind

val repositoryModule = module {
    singleOf(::RepositoryImpl) bind Repository::class
}
