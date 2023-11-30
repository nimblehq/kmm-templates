package co.nimblehq.kmm.template.domain.repositories

import co.nimblehq.kmm.template.domain.models.Model
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getUsers(): Flow<List<Model>>
}
