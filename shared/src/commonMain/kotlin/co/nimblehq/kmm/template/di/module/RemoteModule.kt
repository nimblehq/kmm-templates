package co.nimblehq.kmm.template.di.module

import co.nimblehq.kmm.template.data.remote.datasources.UserRemoteDataSource
import org.koin.dsl.module
import co.nimblehq.kmm.template.data.remote.ApiClient
import co.nimblehq.kmm.template.data.remote.datasources.UserRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val remoteModule = module {
    singleOf(::ApiClient)
    singleOf(::UserRemoteDataSourceImpl) bind UserRemoteDataSource::class
}
