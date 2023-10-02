package co.nimblehq.kmm.template.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.*

@Composable
fun ComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val typography = LocalAppTypography.current
    val shapes = LocalAppShapes.current

    CompositionLocalProvider(
        LocalAppColors provides colors
    ) {
        MaterialTheme(
            colors = colors.themeColors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

/**
 * Alternate to [MaterialTheme] allowing us to add our own theme systems
 * or to extend [MaterialTheme]'s types e.g. return our own [Colors] extension.
 */
object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalAppShapes.current

    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimensions.current

    val styles: AppStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalAppStyles.current
}
