package co.nimblehq.kmm.sample.di

import co.nimblehq.kmm.sample.di.modules.*
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
): KoinApplication {
    val dataModules = listOf(remoteModule, repositoryModule)
    val domainModules = listOf(useCaseModule)

    return startKoin {
        appDeclaration()
        modules(dataModules + domainModules + platformModule())
    }
}
