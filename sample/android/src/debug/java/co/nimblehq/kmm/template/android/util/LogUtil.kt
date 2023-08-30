package co.nimblehq.kmm.template.android.util

import timber.log.Timber

object LogUtil {

    fun setUpLogging() {
        Timber.plant(Timber.DebugTree())
    }
}
