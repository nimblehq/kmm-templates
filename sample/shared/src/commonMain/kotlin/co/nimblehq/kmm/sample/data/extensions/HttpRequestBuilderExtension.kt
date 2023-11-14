package co.nimblehq.kmm.sample.data.extensions

import co.nimblehq.kmm.sample.BuildKonfig
import io.ktor.client.request.*

fun HttpRequestBuilder.path(path: String) {
    url(BuildKonfig.BASE_URL.plus(path))
}
