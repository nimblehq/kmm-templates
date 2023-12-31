package co.nimblehq.kmm.template.data.extensions

import co.nimblehq.kmm.template.BuildKonfig
import io.ktor.client.request.*

fun HttpRequestBuilder.path(path: String) {
    url(BuildKonfig.BASE_URL.plus(path))
}
