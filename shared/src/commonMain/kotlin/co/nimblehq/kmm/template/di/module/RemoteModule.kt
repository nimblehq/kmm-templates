package co.nimblehq.kmm.template.di.module

import co.nimblehq.kmm.template.data.remote.datasources.RemoteDataSource
import org.koin.dsl.module
import co.nimblehq.kmm.template.data.remote.ApiClient
import co.nimblehq.kmm.template.data.remote.datasources.RemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val remoteModule = module {
    singleOf(::ApiClient)
    singleOf(::RemoteDataSourceImpl) bind RemoteDataSource::class
}
