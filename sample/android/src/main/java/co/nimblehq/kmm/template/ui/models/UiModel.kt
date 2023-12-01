package co.nimblehq.kmm.template.ui.models

import co.nimblehq.kmm.template.domain.models.Model

data class UiModel(
    val id: Int
)

fun Model.toUiModel() = UiModel(id = id ?: -1)
