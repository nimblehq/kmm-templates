package co.nimblehq.kmm.template

import android.app.Application
import co.nimblehq.kmm.template.di.androidViewModelModule
import co.nimblehq.kmm.template.util.LogUtil
import co.nimblehq.kmm.template.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LogUtil.setUpLogging()
        initKoin {
            androidContext(applicationContext)
            modules(androidViewModelModule)
        }
    }
}
