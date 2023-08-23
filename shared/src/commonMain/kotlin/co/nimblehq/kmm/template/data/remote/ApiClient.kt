package co.nimblehq.kmm.template.data.remote

import co.nimblehq.kmm.template.data.extensions.path
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.logging.*
import kotlinx.serialization.json.Json
import io.github.aakira.napier.LogLevel.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow

internal class ApiClient(
    engine: HttpClientEngine,
) {
    val httpClient: HttpClient
    val json = Json {
        prettyPrint = true
        isLenient = true
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    init {
        Napier.takeLogarithm()
        Napier.base(DebugAntilog())
        httpClient = HttpClient(engine = engine) {
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.log(DEBUG, message = message)
                    }
                }
            }

            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    suspend inline fun <reified T> get(path: String): Flow<T> =
        request(path, HttpMethod.Get)

    suspend inline fun <reified T> post(path: String, requestBody: Any): Flow<T> =
        request(path, HttpMethod.Post, requestBody)

    suspend inline fun <reified T> request(path: String, method: HttpMethod, requestBody: Any? = null): T {
        return httpClient.request(
            HttpRequestBuilder().apply {
                this.method = method
                path(path)
                requestBody?.let { setBody(requestBody) }
                contentType(ContentType.Application.Json)
            }
        ).body()
    }
}
