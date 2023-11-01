package co.nimblehq.kmm.sample.data.remote.datasources

import co.nimblehq.kmm.sample.data.remote.models.responses.Response
import co.nimblehq.kmm.sample.data.remote.ApiClient

interface RemoteDataSource {
    suspend fun getUsers(): List<Response>
}

internal class RemoteDataSourceImpl(private val apiClient: ApiClient) : RemoteDataSource {
    override suspend fun getUsers(): List<Response> {
        return apiClient.get(
            path = "users"
        )
    }
}
