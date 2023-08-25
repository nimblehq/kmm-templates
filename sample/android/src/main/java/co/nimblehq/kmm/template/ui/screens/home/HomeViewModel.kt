package co.nimblehq.kmm.template.ui.screens.home

import androidx.lifecycle.viewModelScope
import co.nimblehq.kmm.template.domain.usecase.UseCase
import co.nimblehq.kmm.template.model.UiModel
import co.nimblehq.kmm.template.model.toUiModel
import co.nimblehq.kmm.template.ui.base.BaseViewModel
import co.nimblehq.kmm.template.util.DispatchersProvider
import kotlinx.coroutines.flow.*

class HomeViewModel(
    dispatchersProvider: DispatchersProvider,
    useCase: UseCase,
) : BaseViewModel() {

    private val _uiModels = MutableStateFlow<List<UiModel>>(emptyList())
    val uiModels: StateFlow<List<UiModel>> = _uiModels

    init {
        useCase()
            .injectLoading()
            .onEach { result ->
                val uiModels = result.map { it.toUiModel() }
                _uiModels.emit(uiModels)
            }
            .flowOn(dispatchersProvider.io)
            .catch { e -> _error.emit(e) }
            .launchIn(viewModelScope)
    }
}
