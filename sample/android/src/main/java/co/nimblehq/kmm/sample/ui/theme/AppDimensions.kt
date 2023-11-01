package co.nimblehq.kmm.sample.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

class AppDimensions {
    // Custom dimensions here
    val spacingNormal = 16.dp
}

internal val LocalAppDimensions = staticCompositionLocalOf { AppDimensions() }
