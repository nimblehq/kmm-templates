package co.nimblehq.kmm.template.android.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.nimblehq.kmm.template.android.ui.navigation.AppNavigation
import co.nimblehq.kmm.template.android.ui.theme.ComposeTheme

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
