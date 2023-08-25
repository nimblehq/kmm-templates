<<<<<<<< HEAD:sample/android/src/main/java/co/nimblehq/kmm/template/ui/navigation/AppDestination.kt
package co.nimblehq.kmm.template.ui.navigation
========
package co.nimblehq.kmm.template.ui
>>>>>>>> d73b0aa ([Chore] Generate & update sample project):sample/android/src/main/java/co/nimblehq/kmm/template/ui/AppDestination.kt

import androidx.navigation.*

sealed class AppDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    open var destination: String = route

    object Up : AppDestination()

    object Home : AppDestination("home")
}
