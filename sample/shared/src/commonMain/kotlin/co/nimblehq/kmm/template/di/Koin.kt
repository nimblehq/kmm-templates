package co.nimblehq.kmm.template.di

import co.nimblehq.kmm.template.di.modules.*
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
