package co.nimblehq.kmm.template.data.remote.models.responses

import co.nimblehq.kmm.template.domain.models.Model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("id") val id: Int?
)

fun Response.toModel() = Model(id)
