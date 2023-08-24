package co.nimblehq.kmm.template.data.extensions

import kotlinx.coroutines.flow.*
import kotlin.experimental.ExperimentalTypeInference

@OptIn(ExperimentalTypeInference::class)
fun <T> flowTransform(@BuilderInference block: suspend FlowCollector<T>.() -> T) = flow {
    runCatching { block() }
        .onSuccess { emit(it) }
        .onFailure { throw it}
}
