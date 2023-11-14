package co.nimblehq.kmm.sample.ui.models

import co.nimblehq.kmm.sample.domain.models.Model

data class UiModel(
    val id: Int
)

fun Model.toUiModel() = UiModel(id = id ?: -1)
