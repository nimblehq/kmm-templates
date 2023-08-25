package co.nimblehq.kmm.template.di.modules

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import co.nimblehq.kmm.template.data.repository.AppPreferencesRepositoryImpl
import co.nimblehq.kmm.template.data.storage.EncryptedSharedPreferences
import co.nimblehq.kmm.template.domain.repository.AppPreferencesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

private const val APP_PREFERENCES = "app_preferences"

val localModule = module {
    singleOf(::AppPreferencesRepositoryImpl) bind AppPreferencesRepository::class
    single {
        PreferenceDataStoreFactory.create(
            produceFile = { androidContext().preferencesDataStoreFile(APP_PREFERENCES) }
        )
    }
    single {
        EncryptedSharedPreferences(androidContext())
    }
}
