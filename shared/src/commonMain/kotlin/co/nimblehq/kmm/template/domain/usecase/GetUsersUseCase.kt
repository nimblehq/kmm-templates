package co.nimblehq.kmm.template.domain.usecase

import co.nimblehq.kmm.template.domain.model.UserModel
import co.nimblehq.kmm.template.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

interface GetUsersUseCase {
    operator fun invoke(): Flow<List<UserModel>>
}

class GetUsersUseCaseImpl(private val repository: Repository) : GetUsersUseCase {

    override fun invoke(): Flow<List<UserModel>> = repository.getUsers()
}
