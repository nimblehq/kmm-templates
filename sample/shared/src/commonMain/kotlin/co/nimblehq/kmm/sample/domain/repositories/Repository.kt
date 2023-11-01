package co.nimblehq.kmm.sample.domain.repositories

import co.nimblehq.kmm.sample.domain.models.Model
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getUsers(): Flow<List<Model>>
}
