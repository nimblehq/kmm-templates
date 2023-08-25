package co.nimblehq.kmm.template.ui

import android.content.Context
import co.nimblehq.kmm.template.R
import co.nimblehq.kmm.template.domain.exceptions.ApiException
import co.nimblehq.kmm.template.extensions.showToast

fun Throwable.userReadableMessage(context: Context): String {
    return when (this) {
        is ApiException -> error?.message
        else -> message
    } ?: context.getString(R.string.error_generic)
}

fun Throwable.showToast(context: Context) =
    context.showToast(userReadableMessage(context))
