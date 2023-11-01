package co.nimblehq.kmm.sample.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.nimblehq.kmm.sample.ui.AppNavigation
import co.nimblehq.kmm.sample.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                AppNavigation()
            }
        }
    }
}
