package co.nimblehq.kmm.template.android

import android.app.Application
import co.nimblehq.kmm.template.android.util.LogUtil

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LogUtil.setUpLogging()
    }
}
