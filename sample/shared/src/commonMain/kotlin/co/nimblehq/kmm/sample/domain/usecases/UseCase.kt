package co.nimblehq.kmm.sample.domain.usecases

import co.nimblehq.kmm.sample.domain.models.Model
import co.nimblehq.kmm.sample.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow

interface UseCase {
    operator fun invoke(): Flow<List<Model>>
}

class UseCaseImpl(private val repository: Repository) : UseCase {

    override fun invoke(): Flow<List<Model>> = repository.getUsers()
}
