package co.nimblehq.kmm.template.data.remote.model.response

import co.nimblehq.kmm.template.domain.model.UserModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("id") val id: Int?
)

fun UserResponse.toModel() = UserModel(id)
