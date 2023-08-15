package co.nimblehq.kmm.template.android.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.nimblehq.kmm.template.Greeting
import co.nimblehq.kmm.template.android.ui.theme.ComposeTheme

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Text(text = Greeting().greet())
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    ComposeTheme {
        HomeScreen()
    }
}
