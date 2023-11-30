package co.nimblehq.kmm.template.data.repositories

import co.nimblehq.kmm.template.data.extensions.flowTransform
import co.nimblehq.kmm.template.data.remote.datasources.RemoteDataSource
import co.nimblehq.kmm.template.data.remote.models.responses.toModel
import co.nimblehq.kmm.template.domain.models.Model
import co.nimblehq.kmm.template.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun getUsers(): Flow<List<Model>> = flowTransform {
        remoteDataSource.getUsers().map { it.toModel() }
    }
}
