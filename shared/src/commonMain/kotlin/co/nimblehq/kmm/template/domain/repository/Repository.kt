package co.nimblehq.kmm.template.domain.repository

import co.nimblehq.kmm.template.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getUsers(): Flow<List<UserModel>>
}
