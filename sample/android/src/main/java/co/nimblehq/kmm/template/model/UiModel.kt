package co.nimblehq.kmm.template.model

import co.nimblehq.kmm.template.domain.model.Model

data class UiModel(
    val id: Int
)

fun Model.toUiModel() = UiModel(id = id ?: -1)
