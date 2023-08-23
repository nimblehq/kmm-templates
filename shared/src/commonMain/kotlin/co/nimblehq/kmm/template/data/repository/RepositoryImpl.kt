package co.nimblehq.kmm.template.data.repository

import co.nimblehq.kmm.template.data.remote.datasources.UserRemoteDataSource
import co.nimblehq.kmm.template.data.remote.model.response.toModel
import co.nimblehq.kmm.template.domain.model.UserModel
import co.nimblehq.kmm.template.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
) : Repository {
    override fun getUsers(): Flow<List<UserModel>> = flow {
        userRemoteDataSource.getUsers().map { it.toModel() }
    }
}
