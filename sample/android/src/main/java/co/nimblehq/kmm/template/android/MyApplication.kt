package co.nimblehq.kmm.template.android

import android.app.Application
import co.nimblehq.kmm.template.android.di.androidViewModelModule
import co.nimblehq.kmm.template.android.util.LogUtil
import co.nimblehq.kmm.template.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LogUtil.setUpLogging()
        initKoin {
            androidContext(applicationContext)
            modules(androidViewModelModule)
        }
    }
}
