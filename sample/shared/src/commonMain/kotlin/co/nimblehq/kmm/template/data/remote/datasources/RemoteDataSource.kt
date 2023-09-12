package co.nimblehq.kmm.template.data.remote.datasources

import co.nimblehq.kmm.template.data.remote.models.responses.Response
import co.nimblehq.kmm.template.data.remote.ApiClient

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
