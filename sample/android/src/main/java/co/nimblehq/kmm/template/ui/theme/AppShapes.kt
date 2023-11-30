package co.nimblehq.kmm.template.ui.theme

import androidx.compose.material.Shapes
import androidx.compose.runtime.staticCompositionLocalOf

private val Shapes = Shapes(
    // Custom shapes here
)

internal val LocalAppShapes = staticCompositionLocalOf { Shapes }
