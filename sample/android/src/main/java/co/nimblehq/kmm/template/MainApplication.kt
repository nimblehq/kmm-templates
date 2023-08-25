package co.nimblehq.kmm.template

import android.app.Application
import co.nimblehq.kmm.template.data.di.initKoin
import co.nimblehq.kmm.template.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(appModule + localModule + viewModelModule)
        }
        setupLogging()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
