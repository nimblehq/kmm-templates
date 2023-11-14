package co.nimblehq.kmm.sample.data.repositories

import co.nimblehq.kmm.sample.data.extensions.flowTransform
import co.nimblehq.kmm.sample.data.remote.datasources.RemoteDataSource
import co.nimblehq.kmm.sample.data.remote.models.responses.toModel
import co.nimblehq.kmm.sample.domain.models.Model
import co.nimblehq.kmm.sample.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun getUsers(): Flow<List<Model>> = flowTransform {
        remoteDataSource.getUsers().map { it.toModel() }
    }
}
