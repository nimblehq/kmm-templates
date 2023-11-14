package co.nimblehq.kmm.sample.ui.screens.home

import androidx.lifecycle.viewModelScope
import co.nimblehq.kmm.sample.domain.usecases.UseCase
import co.nimblehq.kmm.sample.ui.base.BaseViewModel
import co.nimblehq.kmm.sample.ui.models.UiModel
import co.nimblehq.kmm.sample.ui.models.toUiModel
import co.nimblehq.kmm.sample.util.DispatchersProvider
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
