package co.nimblehq.kmm.template.data.remote.datasources

import co.nimblehq.kmm.template.data.remote.model.responses.UserResponse
import co.nimblehq.kmm.template.data.remote.ApiClient

interface UserRemoteDataSource {
    suspend fun getUsers(): List<UserResponse>
}

internal class UserRemoteDataSourceImpl(private val apiClient: ApiClient) : UserRemoteDataSource {
    override suspend fun getUsers(): List<UserResponse> {
        return apiClient.get(
            path = "users"
        )
    }
}
