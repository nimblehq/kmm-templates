package co.nimblehq.kmm.template.util

import timber.log.Timber

object LogUtil {

    fun setUpLogging() {
        Timber.plant(Timber.DebugTree())
    }
}
