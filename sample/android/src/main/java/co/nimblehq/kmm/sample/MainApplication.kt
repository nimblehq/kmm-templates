package co.nimblehq.kmm.sample

import android.app.Application
import co.nimblehq.kmm.sample.di.initKoin
import co.nimblehq.kmm.sample.di.modules.appModule
import co.nimblehq.kmm.sample.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(appModule + viewModelModule)
        }
        setupLogging()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
