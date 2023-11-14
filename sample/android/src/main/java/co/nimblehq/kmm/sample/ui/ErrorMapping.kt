package co.nimblehq.kmm.sample.ui

import android.content.Context
import co.nimblehq.kmm.sample.R
import co.nimblehq.kmm.sample.domain.exceptions.ApiException
import co.nimblehq.kmm.sample.extensions.showToast

fun Throwable.userReadableMessage(context: Context): String {
    return when (this) {
        is ApiException -> message
        else -> message
    } ?: context.getString(R.string.error_generic)
}

fun Throwable.showToast(context: Context) =
    context.showToast(userReadableMessage(context))
