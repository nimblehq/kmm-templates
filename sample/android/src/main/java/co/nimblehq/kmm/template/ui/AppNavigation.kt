<<<<<<<< HEAD:sample/android/src/main/java/co/nimblehq/kmm/template/ui/navigation/AppNavigation.kt
package co.nimblehq.kmm.template.ui.navigation
========
package co.nimblehq.kmm.template.ui
>>>>>>>> d73b0aa ([Chore] Generate & update sample project):sample/android/src/main/java/co/nimblehq/kmm/template/ui/AppNavigation.kt

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import co.nimblehq.kmm.template.ui.screens.home.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestination.Home.destination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestination.Home) {
            HomeScreen(
                navigator = { destination -> navController.navigate(destination) }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    destination: AppDestination,
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        arguments = destination.arguments,
        deepLinks = deepLinks,
        content = content
    )
}

private fun NavHostController.navigate(appDestination: AppDestination) {
    when (appDestination) {
        is AppDestination.Up -> navigateUp()
        else -> navigate(route = appDestination.destination)
    }
}
